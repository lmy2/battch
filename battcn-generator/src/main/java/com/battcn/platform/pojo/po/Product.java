package com.battcn.platform.pojo.po;

import com.battcn.platform.pojo.RecordEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_bus_product")
public class Product extends RecordEntity {
    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 货物名称
     */
    private String name;

    /**
     * 货物类别
     */
    private String type;

    /**
     * 单位
     */
    private String unit;

    /**
     * 规格型号
     */
    private String model;

    /**
     * 备注
     */
    private String remark;

    /**
     * 系统识别号（企业字母简称+001顺序号）
     */
    private String identify;

    /**
     * 所属公司
     */
    private Integer company;

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
     * 获取货物名称
     *
     * @return name - 货物名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置货物名称
     *
     * @param name 货物名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取货物类别
     *
     * @return type - 货物类别
     */
    public String getType() {
        return type;
    }

    /**
     * 设置货物类别
     *
     * @param type 货物类别
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 获取规格型号
     *
     * @return model - 规格型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置规格型号
     *
     * @param model 规格型号
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取系统识别号（企业字母简称+001顺序号）
     *
     * @return identify - 系统识别号（企业字母简称+001顺序号）
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * 设置系统识别号（企业字母简称+001顺序号）
     *
     * @param identify 系统识别号（企业字母简称+001顺序号）
     */
    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    /**
     * 获取所属公司
     *
     * @return company - 所属公司
     */
    public Integer getCompany() {
        return company;
    }

    /**
     * 设置所属公司
     *
     * @param company 所属公司
     */
    public void setCompany(Integer company) {
        this.company = company;
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