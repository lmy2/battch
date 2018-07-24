package com.battcn.platform.controller;

import com.battcn.framework.common.exception.BattcnException;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.pojo.po.Operate;
import com.battcn.platform.pojo.po.SysCode;
import com.battcn.platform.service.MenuService;
import com.battcn.platform.service.OperateService;
import com.battcn.platform.service.SysCodeService;
import com.battcn.platform.util.SessionUtil;
import com.mysql.jdbc.Connection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;


/**
 * @author Levin
 */
@Api(value = "公共controller", description = "代码表获取", tags = "1.0")
@Controller
public class CommonController extends BaseController {

    @Autowired
    private  SysCodeService sysCodeService;


    @GetMapping(value = "/codeList")
    @ApiOperation(value = "根据CODE获取代码列表", httpMethod = "GET")
    @ResponseBody
    public List<SysCode> codeList(String  code) {
        return  this.sysCodeService.listByCate(code);
    }

}
