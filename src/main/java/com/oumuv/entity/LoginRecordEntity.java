package com.oumuv.entity;

import java.util.Date;

public class LoginRecordEntity {
    private Long userId;

    private Date loginDate;

    private String loginSite;
    
    private String loginIp;

    public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp == null ? null : loginIp.trim();
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginSite() {
        return loginSite;
    }

    public void setLoginSite(String loginSite) {
        this.loginSite = loginSite == null ? null : loginSite.trim();
    }
}