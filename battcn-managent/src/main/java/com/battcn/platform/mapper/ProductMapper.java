package com.battcn.platform.mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Product;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


public interface ProductMapper extends BaseMapper<Product> {


    @Select("select * from t_bus_product where id=#{id}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "company", column = "id",
                    many = @Many(select = "com.battcn.platform.mapper.CompanyMapper.selectById", fetchType =
                            FetchType.LAZY))})
    Product selectById(@Param("id") Integer id);


    @Select("select * from t_bus_product where type=#{product.type} and company =#{product.company}  " +
            " and (name like #{orlike} or model like #{orlike} or identify like  #{orlike} )")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "company", column = "id",
                    one = @One(select = "com.battcn.platform.mapper.CompanyMapper.selectById", fetchType =
                            FetchType.LAZY))})
    List<Product> selectByCondtion(Product product, String orlike);
}