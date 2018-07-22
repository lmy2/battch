package com.battcn.platform.service;

import com.battcn.framework.common.model.TreeNode;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.enums.EnumStatus;
import com.battcn.platform.pojo.dto.PermissionDto;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Menu;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface CompanyService extends BaseService<Company> {
    /**
     * 动态查询 企业信息
     * @param grid
     * @param param
     * @return
     */
    PageInfo<Company> listForDataGrid(DataGrid grid, Company param);
    /**
     * 根据编号判断 添加/保存 菜单信息
     *
     * @param company
     */
    void saveOrUpdate(Company company);

}
