package com.battcn.platform.service.impl;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.CompanyMapper;
import com.battcn.platform.mapper.SysCodeMapper;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.pojo.po.SysCode;
import com.battcn.platform.service.CompanyService;
import com.battcn.platform.service.SysCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author Levin
 */
@Service
public class SysCodeServiceImpl extends BaseServiceImpl<SysCode> implements SysCodeService {
    @Autowired
    private  SysCodeMapper sysCodeMapper;

    @Override
    public List<SysCode> listByCate(String cate) {
        return sysCodeMapper.listByCate(cate);
    }

    @Override
    public PageInfo<SysCode> listSysCodeForDataGrid(DataGrid grid,String cate) {
        return PageHelper.startPage(grid.getPageNum(), grid.getPageSize()).doSelectPageInfo(() -> this.sysCodeMapper.listByCate(cate));
    }

    @Override
    public void saveOrUpdate(SysCode sysCode) {
        sysCode.setGmtModified(new Date());
        if (sysCode.getId() != null) {
            super.updateSelectiveById(sysCode);
        } else {
            super.insertSelective(sysCode);
        }
    }

    @Override
    public List<SysCode> listParentCode() {
        return this.sysCodeMapper.listParentCode();
    }
}
