package com.oumuv.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class ClienEntity {
    private Long id;

    @Excel(name = "姓名",isImportField = "true_st")
    private String name;
    @Excel(name = "联系电话",isImportField = "true_st")
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

    private Long uid;

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
        this.name = name == null ? null : name.trim();
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
        this.address = address == null ? null : address.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
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
        this.status = status == null ? null : status.trim();
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
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getScaleOfCompany() {
        return scaleOfCompany;
    }

    public void setScaleOfCompany(String scaleOfCompany) {
        this.scaleOfCompany = scaleOfCompany == null ? null : scaleOfCompany.trim();
    }

    public Date getReturnvisitTime() {
        return returnvisitTime;
    }

    public void setReturnvisitTime(Date returnvisitTime) {
        this.returnvisitTime = returnvisitTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}