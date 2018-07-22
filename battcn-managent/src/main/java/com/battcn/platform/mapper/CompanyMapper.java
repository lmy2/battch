package com.battcn.platform.mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.enums.EnumStatus;
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Levin
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {


}