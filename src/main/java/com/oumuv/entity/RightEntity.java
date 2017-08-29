package com.oumuv.entity;

public class RightEntity {
    private Long rightCode;

    private Long rightParentCode;

    private String rightType;

    private String rightText;

    private String rightUrl;

    private String rightTip;

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
}