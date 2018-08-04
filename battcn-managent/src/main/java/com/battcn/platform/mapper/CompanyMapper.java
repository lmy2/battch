package com.battcn.platform.mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.enums.EnumStatus;
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Menu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Set;

/**
 * @author lmyhz
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
    @Update("update  t_bus_company  set deleted=#{deleted}  WHERE id = #{id}")
    void  updateDeletedById(@Param("id") Integer id,@Param("deleted") Integer deleted);

    @Select("select * from t_bus_company where id=#{id}")
    @Results({@Result(id=true,property="id",column="id"),
        @Result(property = "name",column = "name"),
        @Result(property = "sendInfoSet",column ="id",
            many = @Many(select = "com.battcn.platform.mapper.SendInfoMapper.selectByCompany",fetchType=FetchType.LAZY))})
    Company selectById(@Param("id") Integer id);

    @Select("SELECT max(id) FROM t_bus_company")
    Integer getMaxId();
}