package com.oumuv.core.info;

import java.io.Serializable;
import java.util.Date;

public class RoleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6424511646834419548L;
	private Long roleId;

	private String roleName;

	private String roleDesc;

	private Integer status;

	private String roleCode;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc == null ? null : roleDesc.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

}