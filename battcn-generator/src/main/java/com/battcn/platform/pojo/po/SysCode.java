package com.battcn.platform.pojo.po;

import com.battcn.platform.pojo.RecordEntity;
import java.util.Date;
import javax.persistence.*;

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
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

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

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取所属类型
     *
     * @return cate - 所属类型
     */
    public String getCate() {
        return cate;
    }

    /**
     * 设置所属类型
     *
     * @param cate 所属类型
     */
    public void setCate(String cate) {
        this.cate = cate == null ? null : cate.trim();
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取最后修改时间
     *
     * @return gmt_modified - 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置最后修改时间
     *
     * @param gmtModified 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}