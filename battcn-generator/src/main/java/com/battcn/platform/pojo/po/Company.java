package com.battcn.platform.pojo.po;

import com.battcn.platform.pojo.RecordEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_bus_company")
public class Company extends RecordEntity {
    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 字母简称
     */
    @Column(name = "letter_abb")
    private String letterAbb;

    /**
     * 公司简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 公司全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 企业类别
     */
    private String type;

    /**
     * 企业代码
     */
    private String code;

    /**
     * 供应商S||客户C
     */
    private String flag;

    /**
     * 统一社会信用代码
     */
    private String scc;

    /**
     * 注册地址
     */
    @Column(name = "reg_address")
    private String regAddress;

    /**
     * 注册地址-省份
     */
    @Column(name = "reg_address_p")
    private String regAddressP;

    /**
     * 注册地址-城市
     */
    @Column(name = "reg_address_c")
    private String regAddressC;

    /**
     * 开户行
     */
    private String bank;

    /**
     * 电话
     */
    private String tel;

    /**
     * 银行账户
     */
    private String account;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否停用
     */
    private Integer deleted;

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
     * 获取字母简称
     *
     * @return letter_abb - 字母简称
     */
    public String getLetterAbb() {
        return letterAbb;
    }

    /**
     * 设置字母简称
     *
     * @param letterAbb 字母简称
     */
    public void setLetterAbb(String letterAbb) {
        this.letterAbb = letterAbb == null ? null : letterAbb.trim();
    }

    /**
     * 获取公司简称
     *
     * @return short_name - 公司简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置公司简称
     *
     * @param shortName 公司简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 获取公司全称
     *
     * @return full_name - 公司全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置公司全称
     *
     * @param fullName 公司全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 获取企业类别
     *
     * @return type - 企业类别
     */
    public String getType() {
        return type;
    }

    /**
     * 设置企业类别
     *
     * @param type 企业类别
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取企业代码
     *
     * @return code - 企业代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置企业代码
     *
     * @param code 企业代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取供应商S||客户C
     *
     * @return flag - 供应商S||客户C
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置供应商S||客户C
     *
     * @param flag 供应商S||客户C
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 获取统一社会信用代码
     *
     * @return scc - 统一社会信用代码
     */
    public String getScc() {
        return scc;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param scc 统一社会信用代码
     */
    public void setScc(String scc) {
        this.scc = scc == null ? null : scc.trim();
    }

    /**
     * 获取注册地址
     *
     * @return reg_address - 注册地址
     */
    public String getRegAddress() {
        return regAddress;
    }

    /**
     * 设置注册地址
     *
     * @param regAddress 注册地址
     */
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress == null ? null : regAddress.trim();
    }

    /**
     * 获取注册地址-省份
     *
     * @return reg_address_p - 注册地址-省份
     */
    public String getRegAddressP() {
        return regAddressP;
    }

    /**
     * 设置注册地址-省份
     *
     * @param regAddressP 注册地址-省份
     */
    public void setRegAddressP(String regAddressP) {
        this.regAddressP = regAddressP == null ? null : regAddressP.trim();
    }

    /**
     * 获取注册地址-城市
     *
     * @return reg_address_c - 注册地址-城市
     */
    public String getRegAddressC() {
        return regAddressC;
    }

    /**
     * 设置注册地址-城市
     *
     * @param regAddressC 注册地址-城市
     */
    public void setRegAddressC(String regAddressC) {
        this.regAddressC = regAddressC == null ? null : regAddressC.trim();
    }

    /**
     * 获取开户行
     *
     * @return bank - 开户行
     */
    public String getBank() {
        return bank;
    }

    /**
     * 设置开户行
     *
     * @param bank 开户行
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * 获取电话
     *
     * @return tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取银行账户
     *
     * @return account - 银行账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置银行账户
     *
     * @param account 银行账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
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
     * 获取是否停用
     *
     * @return deleted - 是否停用
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否停用
     *
     * @param deleted 是否停用
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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