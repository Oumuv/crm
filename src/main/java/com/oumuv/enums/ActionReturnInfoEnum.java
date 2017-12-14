package com.oumuv.enums;

/**
 * 操作状态枚举类
 * SUCCESS(1,"操作成功") ,
 * ERROR(0,"操作失败"),
 * ERROR_TIMEOUT(-2,"系统超时");
 */
public enum ActionReturnInfoEnum {
    SUCCESS(1,"操作成功") ,
    ERROR(0,"操作失败"),
    ERROR_TIMEOUT(-2,"系统超时");

    private int state;

    private String stateInfo;

    ActionReturnInfoEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ActionReturnInfoEnum stateOf(int index) {
        for(ActionReturnInfoEnum state : values()){
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
