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
import com.battcn.platform.pojo.po.Product;
import com.battcn.platform.pojo.po.SendInfo;
import com.battcn.platform.service.CompanyService;
import com.battcn.platform.service.ProductService;
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
@RequestMapping("/bus/product")
@Api(value = "产品管理")
@ApiIgnore
public class ProductController
        extends BaseController {
    @Autowired
    private ProductService productService;

    @Autowired
    private SysCodeService sysCodeService;

    @RequestMapping(value = "/list")
    @BattcnLog(description = "进入产品管理的页面", module = "业务管理-产品管理", methods = "产品列表")
    @ApiOperation(value = "跳转产品管理页面", hidden = true)
    public String list(HttpServletRequest request)
            throws BattcnException {
        //供应商列表
        //货物类别列表
        request.setAttribute("proTypes", "BUS_PRODUCT_TYPE");
        return "bus/product/list";
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    @ApiOperation(value = "根据分页条件查询分页的结果集", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
            @ApiResponse(code = 500, message = "系统错误,请联系管理人员")})
    public PageInfo<Product> query(
            DataGrid grid, Product product) {
        return this.productService.listForDataGrid(grid, product);
    }

    @GetMapping(value = "/edit")
    public String edit(Integer id, HttpServletRequest request) {
         Product product = new Product();
        if (id != null) {
            product = this.productService.selectById(id);
        }

        request.setAttribute("dto", product);


        //货物类别列表
        request.setAttribute("proTypes", this.sysCodeService.listByCate("BUS_PRODUCT_TYPE"));
        return "bus/product/edit";
    }

    @BattcnLog(module = "业务管理-产品管理", methods = "保存产品", description = "添加/修改产品")
    @PostMapping(value = "/save")
    @ResponseBody
    public ApiResult<String> save(
            Product product) {

        if (product != null) {
            this.productService.saveOrUpdate(product);
        }

        return ApiResult.SUCCESS;
    }

    @BattcnLog(module = "业务管理-产品管理", methods = "删除供应商", description = "删除产品")
    @PostMapping(value = "/remove")
    @ResponseBody
    public ApiResult<String> del(
            Integer[] ids) {
        Lists.newArrayList(ids).forEach(this.productService::deleteById);
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

        Workbook workBook = ExcelExportUtil.exportExcel(new ExportParams("产品", "产品详情"),
                Company.class, this.productService.listAll());
        String fileName = "产品-" + DateFormatUtils.format(new Date(), "YYYY-MM-DD") + ".xlsx";
        response.addHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        response.setContentType("application/vnd.ms-excel");
        OutputStream os = response.getOutputStream();
        workBook.write(os);
        os.flush();
        os.close();
    }

}
