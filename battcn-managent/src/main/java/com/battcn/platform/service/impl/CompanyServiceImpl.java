package com.battcn.platform.service.impl;

import com.battcn.framework.common.model.TreeNode;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.enums.EnumStatus;
import com.battcn.platform.mapper.AuthMapper;
import com.battcn.platform.mapper.CompanyMapper;
import com.battcn.platform.mapper.MenuMapper;
import com.battcn.platform.mapper.OperateMapper;
import com.battcn.platform.pojo.dto.PermissionDto;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Log;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.service.CompanyService;
import com.battcn.platform.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;


/**
 * @author Levin
 */
@Service public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService
{

    private final CompanyMapper companyMapper;

    @Autowired public CompanyServiceImpl(CompanyMapper companyMapper)
    {
        this.companyMapper = companyMapper;

    }

    @Override public PageInfo<Company> listForDataGrid(DataGrid grid, Company param)
    {
        Example example = new Example(Company.class);
        Example.Criteria criteria1 = example.createCriteria();
        criteria1.andEqualTo("flag2", param.getFlag2());
        if (StringUtils.isNotBlank(param.getType()))
        {
            criteria1.andEqualTo("type", param.getType());
        }
        if (StringUtils.isNotBlank(param.getRegAddressP()))
        {
            criteria1.andEqualTo("regAddressP", param.getRegAddressP());
        }
        example.and(criteria1);
        String search = grid.getSearch(); //模糊查询
        if (StringUtils.isNotBlank(search))
        {
            Example.Criteria criteria2 = example.createCriteria();
            criteria2.orLike("shortName", "%" + search.trim() + "%");
            criteria2.orLike("fullName", "%" + search.trim() + "%");
            //子查询(暂不实现)
            example.and(criteria2);
        }
        return PageHelper.startPage(grid.getPageNum(), grid.getPageSize()).doSelectPageInfo(
            () -> this.companyMapper.selectByExample(example));
    }

    /**
     * 根据编号判断 添加/保存 菜单信息
     *
     * @param company
     */
    @Override public void saveOrUpdate(Company company)
    {
        company.setGmtModified(new Date());
        if (company.getId() != null)
        {
            super.updateSelectiveById(company);
        }
        else
        {
            super.insertSelective(company);
        }
    }

    @Override public void updateDeletedById(Integer id, Integer deleted)
    {
        companyMapper.updateDeletedById(id, deleted);
    }

    @Override public Company selectById(Integer id)
    {
        return companyMapper.selectById(id);
    }
}
