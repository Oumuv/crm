package com.oumuv.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oumuv.core.JedisUtil;
import com.oumuv.core.ObjectUtil;
import com.oumuv.entity.LoginRecordEntity;
import com.oumuv.entity.User;
import com.oumuv.service.LoginRecordService;
import com.oumuv.service.UserService;
import com.oumuv.utils.AccessSiteUtil;
import com.oumuv.utils.MD5Util;

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

}
