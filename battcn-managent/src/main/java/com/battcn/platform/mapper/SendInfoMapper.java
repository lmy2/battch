package com.battcn.platform.mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.SendInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;


@Mapper
public interface SendInfoMapper extends BaseMapper<SendInfo> {

    @Select("select * from t_bus_sendInfo where company=#{companyId}")
    @Results({
        @Result(id=true,property="id",column="id"),
        @Result(property="name",column="name"),
        @Result(property="company",column="company",javaType=Company.class,
            one=@One(select="com.battcn.platform.mapper.CompanyMapper.selectById"))
    })
    public Set<SendInfo> selectByCompany(int companyId);
}