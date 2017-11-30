package com.oumuv.entity;

import java.util.List;

public class RightEntity {

	private Long rightCode;

	private Long rightParentCode;

	private Integer rightType;

	private String rightText;

	private String rightUrl;

	private String rightTip;

	private Boolean ispatent;

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

	public Integer getRightType() {
		return rightType;
	}

	public void setRightType(Integer rightType) {
		this.rightType = rightType;
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

	public Boolean getIspatent() {
		return ispatent;
	}

	public void setIspatent(Boolean ispatent) {
		this.ispatent = ispatent;
	}


}