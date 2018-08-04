package com.battcn.platform.service.impl;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.CompanyMapper;
import com.battcn.platform.mapper.ProductMapper;
import com.battcn.platform.mapper.SendInfoMapper;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Product;
import com.battcn.platform.pojo.po.SendInfo;
import com.battcn.platform.service.CompanyService;
import com.battcn.platform.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;


/**
 * @author Levin
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public PageInfo<Product> listForDataGrid(DataGrid grid, Product param) {
        String search = grid.getSearch(); //模糊查询

        return PageHelper.startPage(grid.getPageNum(), grid.getPageSize()).doSelectPageInfo(
                () -> this.productMapper.selectByCondtion(param, search));
    }

    /**
     * 根据编号判断 添加/保存 菜单信息
     *
     * @param product
     */
    @Override
    @Transactional
    public void saveOrUpdate(Product product) {
        product.setGmtModified(new Date());
        //保存公司外键
        product.setCompany2(product.getCompany().getId());
        if (product.getId() != null) {
            super.updateSelectiveById(product);
        } else {

            super.insertSelective(product);
        }

    }


    @Override
    public Product selectById(Integer id) {
        return productMapper.selectById(id);
    }
}
