package com.oumuv.entity;

import java.util.List;

public class RightEntity {
    private Long rightCode;

    private Long rightParentCode;

    private String rightType;

    private String rightText;

    private String rightUrl;

    private String rightTip;

    private Integer ispatent;
    
    private List<RightEntity> rlist;

    public List<RightEntity> getRlist() {
		return rlist;
	}

	@Override
	public String toString() {
		return "RightEntity [rightCode=" + rightCode + ", rightParentCode="
				+ rightParentCode + ", rightType=" + rightType + ", rightText="
				+ rightText + ", rightUrl=" + rightUrl + ", rightTip="
				+ rightTip + ", ispatent=" + ispatent + ", rlist=" + rlist
				+ "]";
	}

	public void setRlist(List<RightEntity> rlist) {
		this.rlist = rlist;
	}

	public Long getRightCode() {
        return rightCode;
    }

    public void setRightCode(Long rightCode) {
        this.rightCode = rightCode;
    }

    public Long getRightParentCode() {
        return rightParentCode;
    }

    public void setRightParentCode(Long rightParentCode) {
        this.rightParentCode = rightParentCode;
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText == null ? null : rightText.trim();
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl == null ? null : rightUrl.trim();
    }

    public String getRightTip() {
        return rightTip;
    }

    public void setRightTip(String rightTip) {
        this.rightTip = rightTip == null ? null : rightTip.trim();
    }

    public Integer getIspatent() {
        return ispatent;
    }

    public void setIspatent(Integer ispatent) {
        this.ispatent = ispatent;
    }
}