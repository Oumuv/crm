package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.oumuv.utils.JedisUtil;
import com.oumuv.utils.ProtostuffUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.oumuv.dao.RightEntityMapper;
import com.oumuv.entity.RightEntity;
import com.oumuv.service.MenuService;

@Service
public class MenuServivceImpl implements MenuService{

	@Autowired
	private RightEntityMapper menuDao;

	@Autowired
	private JedisUtil jedisUtil;

	private final String ALLMENUS = "ALLMENUS";//所有菜单的缓存 key
	/**
	 * 获取菜单
	 * */
	public List<RightEntity> getMenuByUid(Long id) {
		String key = "getMenuByUid:"+id;
		byte[] bytes = jedisUtil.get(key.getBytes());
		if (bytes != null) {
			List<RightEntity> deserialize = ProtostuffUtil.deserializeList(bytes, RightEntity.class);
			return deserialize;
		}else{
			List<RightEntity> rightByUId = menuDao.getRightByUId(id);
			byte[] bytes1 = ProtostuffUtil.serializeList(rightByUId);
			jedisUtil.set(key.getBytes(),bytes1,60*5);//缓存5分钟
			return rightByUId;
		}
	}
	public List<RightEntity> getAllMenus() {
		byte[] bytes = jedisUtil.get(ALLMENUS.getBytes());
		if (bytes != null) {
			List<RightEntity> deserialize = ProtostuffUtil.deserializeList(bytes, RightEntity.class);
			return deserialize;
		}else{
			List<RightEntity> list = menuDao.getAllRightEntity();
			byte[] bytes1 = ProtostuffUtil.serializeList(list);
			jedisUtil.set(ALLMENUS.getBytes(),bytes1,60*5);//缓存5分钟
			return list;
		}

	}
	public void updataMenu(RightEntity rightEntity) {
		try {
			menuDao.updateByPrimaryKeySelective(dispose(rightEntity));
			jedisUtil.del(ALLMENUS.getBytes());//清除ALLMENUS缓存
		} catch (Exception e) {
			throw new RuntimeException("更新菜单失败");
		}
	}
	public RightEntity getMenu(Long id) {
		RightEntity rightEntity = menuDao.selectByPrimaryKey(id);
		return rightEntity;
	}
	public void insertMenu(RightEntity rightEntity) {
		//如果是子菜单则需要将父菜单的isparent属性改成true
		if(null!=rightEntity.getRightParentCode()&&!rightEntity.getRightParentCode().equals("")){
			RightEntity r = new RightEntity();
			r.setRightCode(rightEntity.getRightParentCode());
			r.setIspatent(true);
			menuDao.updateByPrimaryKeySelective(r);
		}
		menuDao.insertSelective(dispose(rightEntity));	
	}
	public List<RightEntity> getMenuByLevel(int level) {
		List<RightEntity> menuByLevel = menuDao.getMenuByLevel(level);
		return menuByLevel;
	}
	
	@Transactional
	public int delMenuByLevel(List<Long> ids) {
		int i=0;
			try {
				for(Long id:ids){
					RightEntity entity = menuDao.selectByPrimaryKey(id);
					if(entity.getRightType()!=1){
						List<RightEntity> list = menuDao.getRightByParentId(entity.getRightParentCode());
						if(list.size()<2){
							RightEntity r = new RightEntity();
							r.setRightCode(entity.getRightParentCode());
							r.setIspatent(false);
							int j = menuDao.updateByPrimaryKeySelective(r);
						}
					}
					i += menuDao.deleteByPrimaryKey(id);
				}
			} catch (Exception e) {
				throw new RuntimeException("数据删除失败");
			}
		return i;
	}

	/**
	 * 空值、null值处理
	 */
	private RightEntity dispose(RightEntity rightEntity){
		
		if(null==rightEntity.getRightText()||rightEntity.getRightText().equals("")){
			rightEntity.setRightText("菜单名未定义");
		}
		if(null==rightEntity.getRightUrl()||rightEntity.getRightUrl().equals("")){
			rightEntity.setRightUrl("open/developing.do");
		}
		if(null==rightEntity.getRightTip()||rightEntity.getRightTip().equals("")){
			rightEntity.setRightTip(null);
		}
		return rightEntity;
		
	}
	public List<String> getMenuNameListByRid(Long rid) {
		List<RightEntity> menuByRid = menuDao.getMenuByRid(rid);
		List<String> namelist = new ArrayList<String>();
		for(RightEntity r:menuByRid){
			namelist.add(r.getRightText());
		}
		return namelist;
	}
	public List<RightEntity> getMenuListByRid(Long rid) {
		return  menuDao.getMenuByRid(rid);
	}
}
