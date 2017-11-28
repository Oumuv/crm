package com.oumuv.core.info;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7680804400728108093L;

	private Long id;

	private String username;

	private String password;

	private String name;

	private String himg;

	private String idcard;

	private String qq;

	private String wechat;

	private String email;

	private Long phone;

	private String birthday;

	private Integer height;

	private Integer weight;

	private String education;

	private String graduateSchool;

	private String major;

	private String graduationTime;

	private String male;

	private Long roleId;

	private Long departmentId;

	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg == null ? null : himg.trim();
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard == null ? null : idcard.trim();
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat == null ? null : wechat.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool == null ? null : graduateSchool
				.trim();
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}

	public String getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(String graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male == null ? null : male.trim();
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}


    
}