package com.battcn.platform.pojo.po;

import com.battcn.platform.pojo.RecordEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_sys_code")
public class SysCode extends RecordEntity {
    /**
     * 自增ID
     */
    @Id
    private Integer id;


    /**
     * 类别代码
     */
    private String code;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 所属类型
     */
    private String cate;


    /**
     * 所属类型
     */
    private String remark;


    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类别代码
     *
     * @return code - 类别代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置类别代码
     *
     * @param code 类别代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取类别名称
     *
     * @return name - 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类别名称
     *
     * @param name 类别名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setValue(String value) {

        this.value = value;

    }
}