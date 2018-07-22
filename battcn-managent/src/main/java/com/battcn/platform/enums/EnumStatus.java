package com.battcn.platform.enums;

public enum EnumStatus {
    SUPPLIER("供应商", "S"), CUSTOM("客户", "C");
    // 成员变量
    private String name;
    private String  code;
    // 构造方法
    private EnumStatus(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getCode() { return this.code; }
    //覆盖方法
    @Override
    public String toString() {
        return this.code+"_"+this.name;
    }
}
