package com.oumuv.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.RightEntityMapper;
import com.oumuv.entity.RightEntity;
import com.oumuv.service.MenuService;

@Service
public class MenuServivceImpl implements MenuService{

	@Autowired
	private RightEntityMapper menuDao;
	/**
	 * 获取菜单
	 * */
	public List<RightEntity> getMenu(Long id) {
		List<RightEntity> rightByUId = menuDao.getRightByUId(id);
		for(RightEntity r:rightByUId){
			if(r.getIspatent()==1){
				List<RightEntity> list = menuDao.getRightByParentId(r.getRightCode());
				if(list.size()>0){
					r.setRlist(list);
				}
			}
		}
		return rightByUId;
	}

}
