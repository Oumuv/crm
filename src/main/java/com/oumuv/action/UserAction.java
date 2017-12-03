package com.oumuv.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.oumuv.core.DeleteFileTimerTask;
import com.oumuv.core.info.Result;
import com.oumuv.core.info.UserInfo;
import com.oumuv.entity.LoginRecordEntity;
import com.oumuv.entity.User;
import com.oumuv.service.LoginRecordService;
import com.oumuv.service.UserService;
import com.oumuv.utils.AccessSiteUtil;
import com.oumuv.utils.DateUtils;
import com.oumuv.utils.JedisUtil;
import com.oumuv.utils.MD5Util;
import com.oumuv.utils.MyCopyUtil;
import com.oumuv.utils.StringTool;
import com.oumuv.utils.ThumbnailatorUtils;

/**
 * @author Administrator user控制层
 */
@Controller
@RequestMapping("/user")
public class UserAction {

	@Autowired
	private JedisUtil jedisUtil;
	@Resource
	private UserService userService;
	@Autowired
	private LoginRecordService loginRecordService;
	
	/**
	 * 打开个人信息编辑页
	 * @param request
	 * @param session
	 * @param map
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(value = "/editPersoninfo.do")
	public String pageResult(HttpServletRequest request, HttpSession session,
			ModelMap map) throws InterruptedException {
		User personInfo = (User) session.getAttribute("user");
		User u = userService.getPersonInfo(personInfo);
		UserInfo user = new UserInfo();
		MyCopyUtil.copyProp(user, u, new String []{"birthday","graduationTime"});
		user.setBirthday(DateUtils.getDateTime(u.getBirthday(), 3));
		user.setGraduationTime(DateUtils.getDateTime(u.getGraduationTime(),3));
		map.put("user", user);
		return "user/person_info";
	}
	/**
	 * 打开头像修改页面
	 * @param request
	 * @param session
	 * @param map
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(value = "/editImg.do")
	public String editImgPage(HttpServletRequest request, HttpSession session,
			ModelMap map) throws InterruptedException {
		User u = (User) session.getAttribute("user");
		User user = userService.getPersonInfo(u);
		map.put("user", user);
		return "user/uploadImg";
	}
	
	/**
	 * 创建文件夹
	 * @param path 文件夹路径
	 * @return
	 */
	public static boolean mkDirectory(String path) {
		File file = null;
		try {
			file = new File(path);
			if (!file.exists()) {
				return file.mkdirs();
			} else {
				return false;
			}
		} catch (Exception e) {
		} finally {
			file = null;
		}
		return false;
	}
	
	
	/**
	 * 头像上传
	 * @param request
	 * @param session
	 * @param response
	 * @param file
	 * @param avatar_src
	 * @param avatar_data
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadImg2.do",produces = "application/json;charset=utf-8")
	public void editImg2(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,@RequestParam("avatar_file")MultipartFile file, String avatar_src,String avatar_data) throws IOException {
		response.setCharacterEncoding("utf-8");
		 // 判断文件是否为空  
		System.out.println("=============================开始上传图片=============================");
		String type = file.getContentType();
		System.out.println("文件类型："+type);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		SimpleDateFormat dy = new SimpleDateFormat("yyyy");//设置年格式
		SimpleDateFormat dm = new SimpleDateFormat("MMdd");//设置月日格式
		Date today = new Date();
		String date = dateformat.format(today);//日期
		String _dy = dy.format(today);//年
		String _dm = dm.format(today);//月日
		Gson gson=new Gson();
        if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
                String path = request.getSession().getServletContext().getRealPath("/") + "/upload/" +_dy+"/"+_dm+"/";
                System.out.println("文件名："+file.getOriginalFilename());
                mkDirectory(path);//创建文件夹路径
                File file2 = new File(path,date +"_" +file.getOriginalFilename());
                String filePath = file2.getPath();
                System.out.println("文件保存路径:"+filePath);
                file.transferTo(file2);// 转存文件  
                JSONObject object =gson.fromJson(avatar_data, JSONObject.class);
                double x = (Double)object.get("x");
                double y = (Double) object.get("y");
                double rotate = (Double) object.get("rotate");
                double width = (Double) object.get("width");
                double height = (Double) object.get("height");
                ThumbnailatorUtils.ImgSourceRegion(filePath,filePath,(int)x,(int)y,(int)width,(int)height,170/*固定宽度*/,170/*固定长度*/,true);
                System.out.println("=============================结束上传图片=============================");
                response.getWriter().write(gson.toJson(new Result(file.getOriginalFilename()+"上传成功",null,200)));
                User user = (User) session.getAttribute("user");
                String imgpath = StringTool.subStringIndex2End("/upload", filePath.replace("\\", "/"));
                String oldimg =request.getSession().getServletContext().getRealPath("/") + user.getHimg();
                new Timer().schedule(new DeleteFileTimerTask(new File(oldimg)), 5000);//延迟删除旧的图片
                user.setHimg(imgpath);
                userService.savePersonInfo(user);
                
            } catch (Exception e) {  
            	response.getWriter().write(gson.toJson(new Result(file.getOriginalFilename()+"上传失败",e.getMessage(),500)));
                e.printStackTrace();  
            }  
        }  
	}
	
	
	/**
	 * shiro的登录认证
	 * @param username
	 * @param password
	 * @param address
	 * @param request
	 * @param map
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String shiroLogin(@Param(value = "usename") String username,
			@Param("password") String password,
			@Param("address") String address, HttpServletRequest request,
			ModelMap map, HttpSession session) throws UnsupportedEncodingException {

		Subject subject = SecurityUtils.getSubject();// 获取subject实例
		boolean authenticated = subject.isAuthenticated();// 判断用户是否已经登录
//			SavedRequest request2 = WebUtils.getSavedRequest(request);
//			String requestUrl = request2.getRequestUrl();//获取登录之前的url
		if(authenticated){
			User user = (User)session.getAttribute("user");
			map.put("user", user);
			return "index";//已经登录直接跳转
		}
		String psw= MD5Util.GetMD5Code(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username,psw);// 使用UsernamePasswordToken对象封装用户名及密码信息
		try {
			subject.login(token);
			map.clear();
			User user = userService.login(username,psw);
			map.put("user", user);
			session.setAttribute("user", user);
			LoginRecordEntity record = new LoginRecordEntity();// 保存登录记录
			record.setUserId(user.getId());
			AccessSiteUtil accessSiteUtil = new AccessSiteUtil();
			// String ipAddr = accessSiteUtil.getIpAddr(request);
			record.setLoginDate(new Timestamp(new Date().getTime()));
			if (!address.equals("")) {
				record.setLoginSite(address);
			} else {
				record.setLoginSite(accessSiteUtil.getAddresses("ip="+ accessSiteUtil.getIpAddr(request), "utf-8"));
			}
			loginRecordService.loginRecored(record);
			return "index";
		} catch (AuthenticationException e) {
			map.clear();
			map.put("username", username);
			map.put("msg1", "密码错误，请重新输入");
			return "forward:/login.jsp";
		}
	}

	/**
	 * 放弃使用的login
	 * @param username
	 * @param password
	 * @param address
	 * @param request
	 * @param map
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/login1")
	public String login(@Param(value = "usename") String username,
			@Param("password") String password,
			@Param("address") String address, HttpServletRequest request,
			ModelMap map, HttpSession session)
			throws UnsupportedEncodingException {
		User user = userService.login(username, MD5Util.GetMD5Code(password));

		if (user == null) {
			map.clear();
			map.put("username", username);
			map.put("msg1", "密码错误，请重新输入");
			return "forward:/login.jsp";
		} else if (user.getUsername().equals(username)
				&& user.getPassword().equals(MD5Util.GetMD5Code(password))) {
			map.clear();
			map.put("user", user);
			session.setAttribute("user", user);
			LoginRecordEntity record = new LoginRecordEntity();// 保存登录记录
			record.setUserId(user.getId());
			AccessSiteUtil accessSiteUtil = new AccessSiteUtil();
			// String ipAddr = accessSiteUtil.getIpAddr(request);
			record.setLoginDate(new Timestamp(new Date().getTime()));
			if (!address.equals("")) {
				record.setLoginSite(address);
			} else {
				record.setLoginSite(accessSiteUtil.getAddresses("ip="
						+ accessSiteUtil.getV4IP(), "utf-8"));
			}
			loginRecordService.loginRecored(record);
			return "index";
		}
		return "forward:/login.jsp";
	}

	@RequestMapping("/check")
	public void check(String username, HttpServletRequest request,
			HttpServletResponse response, ModelMap map) throws IOException {
		String user = userService.check(username);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (username.equals("")) {
			response.getWriter().write("请输入用户名");
		} else if (user == null) {
			response.getWriter().write("用户不存在");
		}
	}

	@RequestMapping("/logout")
	public String check(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		session.removeAttribute("user");
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}

	/**
	 * 获取当前用户近30天的登录记录图标数据
	 * 
	 * @param uid
	 *            用户id
	 * @throws Exception 
	 * */
	@RequestMapping("/getloginrecords")
	public void getloginRecoredForMonth(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) session.getAttribute("user");
		String key="login_records_"+user.getId();
		String value = jedisUtil.get(key);//查redis是否有该数据的缓存，没有缓存或者缓存已经过期则再查db
		if(value!=null){
			response.getWriter().write(value);//有缓存则直接返回缓存的数据
		}else{
			//查db数据库
			List<Map<String, String>> maplis = loginRecordService.getloginRecoredForMonth(user.getId());//查询30天内登陆次数
			Map<Object, Object> loginCount = new HashMap<Object, Object>();//保存30天内登陆次数统计
			Map<Object, Object> resultMap = new LinkedHashMap<Object, Object>();//返回前端的json数据
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String endDate = sdf.format(new Date());// 当前时间
			String dateformat = null;
			Calendar calendar = Calendar.getInstance();
			for (Map m : maplis) {
				Object t = m.get("t");//t登陆的日期
				Object c = m.get("c");//登陆的次数
				loginCount.put(t, c);
				}
			
			//遍历保存记录
			for (int i = 29; i >= 0; i--) {
				calendar.setTime(sdf.parse(endDate));
				calendar.add(calendar.DATE, -i);
				dateformat = sdf.format(calendar.getTime());
				if (loginCount.get(dateformat) != null) {
					resultMap.put(dateformat, loginCount.get(dateformat));
					continue;
				}
				resultMap.put(dateformat, 0);
			}
			String json = new ObjectMapper().writeValueAsString(resultMap);//转换json格式
			jedisUtil.set(key, json,60);//从db查出的数据缓存到redis，缓存时间为60秒
			response.getWriter().write(json);
		}
	}
	
	/**
	 * 保存个人信息
	 * @param user
	 */
	@ResponseBody
	@RequestMapping(value="/savePersonInfo.do")
	public void savePersoninfo(UserInfo user){
		User u = new User();
		
		MyCopyUtil.copyProp(u, user, new String []{"birthday","graduationTime"});
		u.setBirthday(DateUtils.parseStr2Date(user.getBirthday(), 3));
		u.setGraduationTime(DateUtils.parseStr2Date(user.getGraduationTime(),3));
		
		int i = 0;
		i = userService.savePersonInfo(u);
		
	}


}
