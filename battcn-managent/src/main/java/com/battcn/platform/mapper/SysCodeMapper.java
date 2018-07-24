package com.battcn.platform.mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Operate;
import com.battcn.platform.pojo.po.SysCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Levin
 */
@Mapper
public interface SysCodeMapper extends BaseMapper<SysCode> {
    @Select("SELECT  t.* FROM t_sys_code t  where t.cate = #{cate}")
    List<SysCode> listByCate(@Param("cate") String cate);
}