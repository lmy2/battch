package com.battcn.platform.service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Product;
import com.github.pagehelper.PageInfo;

/**
 * @author lmyhz
 */
public interface ProductService extends BaseService<Product> {
    /**
     * 动态查询 产品信息
     *
     * @param grid
     * @param param
     * @return
     */
    PageInfo<Product> listForDataGrid(DataGrid grid, Product param);

    /**
     * 根据编号判断 添加/保存 產品信息
     *
     * @param product
     */
    void saveOrUpdate(Product product);



    /**
     * @param id
     * @return
     */
    Product selectById(Integer id);
}
