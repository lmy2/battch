package com.battcn.platform.controller.sys;

import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.Log;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.pojo.po.SysCode;
import com.battcn.platform.service.MenuService;
import com.battcn.platform.service.SysCodeService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.battcn.framework.common.exception.BattcnException.notFound;


/**
 * @author Levin
 */
@Controller
@RequestMapping("/sys/dict")
@Api(value = "字典管理")
@ApiIgnore
public class DictController extends BaseController {
    @Autowired
    private  SysCodeService sysCodeService;

    @RequestMapping(value = "/list")
    @BattcnLog(description = "进入字典管理页面", module = "配置管理", methods = "字典list")
    @ApiOperation(value = "跳转字典管理页面", hidden = true)
    public String list(HttpServletRequest request) throws BattcnException {
        //獲取所有一級分類
        request.setAttribute("cates", this.sysCodeService.listParentCode());
        return "sys/dict/list";
    }
    @RequestMapping(value = "/query")
    @ResponseBody
    @ApiOperation(value = "根据分类查询代码结果集", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
            @ApiResponse(code = 500, message = "系统错误,请联系管理人员")})
    public PageInfo<SysCode> query(DataGrid grid, String cate) {
        return this.sysCodeService.listSysCodeForDataGrid(grid,cate);
    }
    @GetMapping(value = "/edit")
    public String edit(Integer id, HttpServletRequest request) {
        if (id != null) {
            request.setAttribute("dto", this.sysCodeService.selectById(id).orElseThrow(() -> notFound("该数据已失效")));
        }
        request.setAttribute("cates", this.sysCodeService.listParentCode());
        return "sys/dict/edit";
    }

    @BattcnLog(module = "字典管理", methods = "保存字典", description = "添加/修改字典信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public ApiResult<String> save(SysCode sysCode) {
        if (sysCode != null) {
            this.sysCodeService.saveOrUpdate(sysCode);
        }
        return ApiResult.SUCCESS;
    }

    @BattcnLog(module = "字典管理", methods = "移除字典", description = "删除字典信息")
    @PostMapping(value = "/remove")
    @ResponseBody
    public ApiResult<String> del(Integer[] ids) {
        Lists.newArrayList(ids).forEach(this.sysCodeService::deleteById);
        return ApiResult.SUCCESS;
    }
    @GetMapping(value = "/codeList")
    @ApiOperation(value = "根据Cate获取代码列表", httpMethod = "GET")
    @ResponseBody
    public List<SysCode> codeList(String  code) {
        code=  StringUtils.replaceAll(code,"\\'","");
        return  this.sysCodeService.listByCate(code);
    }

}
