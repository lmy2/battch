package com.battcn.platform.controller.bus;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.enums.EnumStatus;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.Company;
import com.battcn.platform.pojo.po.SendInfo;
import com.battcn.platform.service.CompanyService;
import com.battcn.platform.service.SysCodeService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author lmy
 */
@Controller
@RequestMapping("/bus/custom")
@Api(value = "客户管理")
@ApiIgnore
public class CustomController
        extends BaseController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private SysCodeService sysCodeService;

    @RequestMapping(value = "/list")
    @BattcnLog(description = "进入客户信息管理的页面", module = "业务管理-客户信息管理", methods = "客户信息列表")
    @ApiOperation(value = "跳转客户信息管理页面", hidden = true)
    public String list( HttpServletRequest request)
            throws BattcnException {
        request.setAttribute("SYS_CODE_TYPE", "BUS_CUSTOM");
        return "bus/supplier/list";
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    @ApiOperation(value = "根据分页条件查询分页的结果集", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
            @ApiResponse(code = 500, message = "系统错误,请联系管理人员")})
    public PageInfo<Company> query(
            DataGrid grid, Company company) {
        //枚举类型无法转换
        company.setFlag2(EnumStatus.CUSTOM.getCode());
        return this.companyService.listForDataGrid(grid, company);
    }

    @GetMapping(value = "/edit")
    public String edit(Integer id, HttpServletRequest request) {
        Company company = new Company();
        if (id != null) {
            company = this.companyService.selectById(id);
        }
        List<SendInfo> sendInfos = company.getSendInfoSet();
        if (CollectionUtils.isEmpty(sendInfos)) {
            sendInfos = new ArrayList<SendInfo>();
            for (int i = 0; i < 3; i++) {
                SendInfo sendInfo = new SendInfo();
                sendInfos.add(sendInfo);
            }

        } else if (sendInfos.size() < 3) {
            for (int i = sendInfos.size(); i < 3; i++) {
                SendInfo sendInfo = new SendInfo();
                sendInfos.add(sendInfo);
            }
        }
        company.setSendInfoSet(sendInfos);
        request.setAttribute("dto", company);

        //下拉菜单--客户类别2
        request.setAttribute("BUS_SUPPLIER", this.sysCodeService.listByCate("BUS_CUSTOM"));
        return "bus/supplier/edit";
    }

    @BattcnLog(module = "业务管理-客户信息管理", methods = "保存客户信息", description = "添加/修改客户信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public ApiResult<String> save(
            Company company) {
        company.setFlag2(EnumStatus.CUSTOM.getCode());
        if (company != null) {
            this.companyService.saveOrUpdate(company);
        }

        return ApiResult.SUCCESS;
    }

    @BattcnLog(module = "业务管理-客户信息管理", methods = "删除客户", description = "删除客户信息")
    @PostMapping(value = "/remove")
    @ResponseBody
    public ApiResult<String> del(
            Integer[] ids) {
        Lists.newArrayList(ids).forEach(this.companyService::deleteById);
        return ApiResult.SUCCESS;
    }

    @BattcnLog(module = "业务管理-客户信息管理", methods = "停用客户", description = "停用客户信息")
    @GetMapping(value = "/update")
    @ResponseBody
    public ApiResult<String> update(
            Integer id, Integer deleted) {
        this.companyService.updateDeletedById(id, deleted);
        return ApiResult.SUCCESS;
    }

    /**
     * 采用网上大神的POI操作, 速度杠杠的：http://git.oschina.net/jueyue/easypoi<br>
     *
     * @param response 响应流
     * @throws Exception 异常信息
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    @ApiOperation(value = "数据导出", hidden = true)
    public void export(
            HttpServletResponse response)
            throws Exception {

        Workbook workBook = ExcelExportUtil.exportExcel(new ExportParams("客户信息", "客户信息详情"),
                Company.class, this.companyService.listAll());
        String fileName = "客户信息-" + DateFormatUtils.format(new Date(), "yyyy-MM-dd") + ".xlsx";
        response.addHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        response.setContentType("application/vnd.ms-excel");
        OutputStream os = response.getOutputStream();
        workBook.write(os);
        os.flush();
        os.close();
    }

}
