package com.battcn.platform.pojo.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.battcn.platform.enums.EnumStatus;
import com.battcn.platform.pojo.RecordEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Table(name = "t_bus_company")
public class Company extends RecordEntity {
    /**
     * 自增ID
     */
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Excel(name = "编号")
    private Integer id;

    /**
     * 字母简称
     */
    @Excel(name = "字母简称")
    @Column(name = "letter_abb")
    private String letterAbb;

    /**
     * 公司简称
     */
    @Excel(name = "公司简称",width = 20)
    @Column(name = "short_name")
    private String shortName;

    /**
     * 公司全称
     */
    @Excel(name = "公司全称",width = 50)
    @Column(name = "full_name")
    private String fullName;

    /**
     * 企业类别
     */
    private String type;

    /**
     * 企业代码
     */
    @Excel(name = "企业代码",width = 20)
    private String code;

    @Column(name = "flag")
    private String flag2;

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    /**
     * 供应商S||客户C
     */
  //  @Enumerated(EnumType.STRING)
   // @Column(name = "flag")
   // private EnumStatus flag = EnumStatus.SUPPLIER;

    /**
     * 统一社会信用代码
     */
    @Excel(name = "统一社会信用代码",width = 30)
    private String scc;
    /**
     * 注册地址--省份
     */
    @Column(name = "reg_address_p")
    private String regAddressP;
    /**
     * 注册地址-城市
     */
    @Column(name = "reg_address_c")
    private String regAddressC;

    public String getRegAddressC() {
        return regAddressC;
    }

    public void setRegAddressC(String regAddressC) {
        this.regAddressC = regAddressC;
    }

    public String getRegAddressP() {

        return regAddressP;
    }

    public void setRegAddressP(String regAddressP) {
        this.regAddressP = regAddressP;
    }


    /**su
     * 注册地址
     */
    @Excel(name = "注册地址",width =50)
    @Column(name = "reg_address")
    private String regAddress;

    /**
     * 开户行
     */
    @Excel(name = "开户行",width = 20)
    private String bank;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String tel;

    /**
     * 银行账户
     */
    @Excel(name = "银行账户")
    private String account;
    /**
     * 是否停用
     */
    @Excel(name = "是否停用",replace = { "是_1", "否_0" })
    private Integer deleted;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    /**
     * 备注
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
     * 设置公司全称2
     *
     * @param fullName 公司全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
   // public EnumStatus getFlag() {
   //     return flag;
   // }

    /**
     * 设置供应商S||客户C
     *
     * @param flag 供应商S||客户C
     */
   // public void setFlag(EnumStatus flag) {
    //    this.flag = flag;
    //}

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

    private Set<SendInfo> sendInfoSet;

    public Set<SendInfo> getSendInfoSet()
    {
        return sendInfoSet;
    }

    public void setSendInfoSet(Set<SendInfo> sendInfoSet)
    {
        this.sendInfoSet = sendInfoSet;
    }
}