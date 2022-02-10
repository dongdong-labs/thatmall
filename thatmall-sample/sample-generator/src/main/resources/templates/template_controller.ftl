package ${tableInfo.getPackageName("Controller")};

import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import ${tableInfo.getPackageName("DTO")}.${tableInfo.getClassName("DTO")} ;
import ${tableInfo.getPackageName("Request")}.${tableInfo.getClassName("Request")} ;
import ${tableInfo.getPackageName("Response")}.${tableInfo.getClassName("Response")} ;
import ${tableInfo.getPackageName("Service")}.${tableInfo.getClassName("Service")} ;
import ${tableInfo.getPackageName("RequestConverter")}.${tableInfo.getClassName("RequestConverter")} ;
import ${tableInfo.getPackageName("ResponseConverter")}.${tableInfo.getClassName("ResponseConverter")} ;

import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.Result;
import org.onedayday.framework.result.PagerResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

/**
* @Title:  ${tableInfo.getClassName("Controller")}
* @Description: ${tableInfo.comment}
* @author ${tableInfo.author}
* @version 1.0
*/

@Api(tags = "${tableInfo.comment}")
@RestController
@RequestMapping("${tableInfo.className?uncap_first}")
@RequiredArgsConstructor
public class ${tableInfo.getClassName("Controller")} extends BaseController {

    private final ${tableInfo.getClassName("Service")} ${tableInfo.getClassName("Service")?uncap_first};

    private final ${tableInfo.getClassName("RequestConverter")} ${tableInfo.getClassName("RequestConverter")?uncap_first};

    private final ${tableInfo.getClassName("ResponseConverter")} ${tableInfo.getClassName("ResponseConverter")?uncap_first};

    @ApiOperation(value = "${tableInfo.comment}新增")
    @RequestMapping(value = "/save${tableInfo.getClassName("PO")}",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "${tableInfo.comment}新增", detail = "${tableInfo.comment}新增")
    public Result save${tableInfo.getClassName("PO")}(@RequestBody ${tableInfo.getClassName("Request")} ${tableInfo.getClassName("Request")?uncap_first}) {
        ${tableInfo.getClassName("Service")?uncap_first}.save${tableInfo.getClassName("PO")}(${tableInfo.getClassName("RequestConverter")?uncap_first}.toTarget(${tableInfo.getClassName("Request")?uncap_first}));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "${tableInfo.comment}删除")
    @RequestMapping(value = "/delete${tableInfo.getClassName("PO")}",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "${tableInfo.comment}删除", detail = "${tableInfo.comment}删除")
    public Result delete${tableInfo.getClassName("PO")}(@RequestBody Set<Long> ids) {

        ${tableInfo.getClassName("Service")?uncap_first}.delete${tableInfo.getClassName("PO")}(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "${tableInfo.comment}修改")
    @RequestMapping(value = "/update${tableInfo.getClassName("PO")}",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "${tableInfo.comment}修改", detail = "${tableInfo.comment}修改")
    public Result update${tableInfo.getClassName("PO")}(@RequestBody ${tableInfo.getClassName("Request")} ${tableInfo.getClassName("Request")?uncap_first}) {

        ${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first} = ${tableInfo.getClassName("RequestConverter")?uncap_first}.toTarget(${tableInfo.getClassName("Request")?uncap_first});
        if(${tableInfo.getClassName("DTO")?uncap_first}.getId() != null){
            ${tableInfo.getClassName("Service")?uncap_first}.update${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")?uncap_first});
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "${tableInfo.comment}分页")
    @RequestMapping(value = "/pager${tableInfo.getClassName("PO")}",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<${tableInfo.getClassName("Response")}>> getPagerResult(@RequestBody Pager<${tableInfo.getClassName("DTO")}> pager) {
        PagerResult<${tableInfo.getClassName("Response")}> pagerResult = new PagerResult<>();
        PagerResult<${tableInfo.getClassName("DTO")}> dtoPagerResult = ${tableInfo.getClassName("Service")?uncap_first}.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(${tableInfo.getClassName("ResponseConverter")?uncap_first}.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
