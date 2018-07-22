package com.battcn.platform.pojo.po;

import com.battcn.platform.pojo.RecordEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_bus_sendinfo")
public class SendInfo extends RecordEntity {
    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 发货地址
     */
    private String address;

    /**
     * 发货联系人
     */
    private Integer contact;

    /**
     * 联系电话
     */
    private String tel;

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
     * 获取发货地址
     *
     * @return address - 发货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置发货地址
     *
     * @param address 发货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取发货联系人
     *
     * @return contact - 发货联系人
     */
    public Integer getContact() {
        return contact;
    }

    /**
     * 设置发货联系人
     *
     * @param contact 发货联系人
     */
    public void setContact(Integer contact) {
        this.contact = contact;
    }

    /**
     * 获取联系电话
     *
     * @return tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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