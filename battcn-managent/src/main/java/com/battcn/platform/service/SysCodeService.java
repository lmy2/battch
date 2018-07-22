package com.battcn.platform.service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.SysCode;
import com.github.pagehelper.PageInfo;

/**
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface SysCodeService extends BaseService<SysCode> {

    List<SysCode> listByCate(String cate);

}
