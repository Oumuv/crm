package com.oumuv.core.info;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oumuv.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClienInfo {
    private Long id;

    private String name;

    private Long phone;

    private String address;

    private String wechat;

    private Long qq;

    private String status;

    private Date createTime;

    private String customerType;

    private String email;

    private String company;

    private String department;

    private String source;

    private String scaleOfCompany;

    private Date returnvisitTime;

    private String remark;

    private User cuser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getScaleOfCompany() {
        return scaleOfCompany;
    }

    public void setScaleOfCompany(String scaleOfCompany) {
        this.scaleOfCompany = scaleOfCompany;
    }

    public Date getReturnvisitTime() { return returnvisitTime; }

    public void setReturnvisitTime(Date returnvisitTime) {
        this.returnvisitTime = returnvisitTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getCuser() { return cuser; }

    public void setCuser(User cuser) { this.cuser = cuser; }
}