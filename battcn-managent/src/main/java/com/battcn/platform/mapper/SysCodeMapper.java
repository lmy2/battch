package com.battcn.platform.mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Menu;
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
    /**
     * 查询所有一级分类,根据 id 升序排序
     *
     * @return 查询结果
     */
    @Select("SELECT * FROM t_sys_code WHERE  cate is null or  cate=''  ORDER BY  ID asc ")
    List<SysCode> listParentCode();
}