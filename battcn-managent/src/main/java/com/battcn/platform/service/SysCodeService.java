package com.battcn.platform.service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.pojo.po.SysCode;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface SysCodeService extends BaseService<SysCode> {

    List<SysCode> listByCate(String cate);
    /**
     * 分页查询 菜单列表
     *
     * @param grid 分页信息
     * @param cate 类别
     * @return 查询结果
     */
    PageInfo<SysCode> listSysCodeForDataGrid(DataGrid grid,String cate);


    /**
     * 根据分类编号判断 添加/保存 菜单信息
     *
     * @param sysCode
     */
    void saveOrUpdate(SysCode sysCode);

    /**
     * 查询一级分类
     *
     * @return 查询结果
     */
    List<SysCode> listParentCode();
}
