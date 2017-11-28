package com.oumuv.core;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.oumuv.entity.User;
import com.oumuv.service.RoleService;
import com.oumuv.service.UserService;

/*
 * 自定义shiroRealm
 * 
 * */
public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User user = (User) getAvailablePrincipal(principals);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		
		info.setRoles(null);//设置用户的角色
		info.setStringPermissions(null);//设置用户的权限
		return info;
	}

	
	
	
	/**
	 * 
	 * 认证用户信息
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
		usertoken.setRememberMe(true);
		String username = usertoken.getUsername();
		String password = String.valueOf(usertoken.getPassword());
		User user = userService.login(username,password);
		return new SimpleAuthenticationInfo(user,password, this.getName());
	}


}
