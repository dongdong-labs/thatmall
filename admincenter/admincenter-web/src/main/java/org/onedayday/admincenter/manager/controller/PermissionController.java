package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IPermissionService;
import org.onedayday.admincenter.manager.converter.PermissionRequestConverter;
import org.onedayday.admincenter.manager.converter.PermissionResponseConverter;
import org.onedayday.admincenter.manager.dto.PermissionDTO;
import org.onedayday.admincenter.manager.request.PermissionRequest;
import org.onedayday.admincenter.manager.response.PermissionResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  PermissionController
* @Description: 用户权限
* @author generator
* @version 1.0
*/

@Api(tags = "用户权限")
@RestController
@RequestMapping("permission")
@RequiredArgsConstructor
public class PermissionController extends BaseController {

    private final IPermissionService iPermissionService;

    private final PermissionRequestConverter permissionRequestConverter;

    private final PermissionResponseConverter permissionResponseConverter;

    @ApiOperation(value = "用户权限新增")
    @RequestMapping(value = "/savePermission",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "用户权限新增", detail = "用户权限新增")
    public Result savePermission(@RequestBody PermissionRequest permissionRequest) {
        iPermissionService.savePermission(permissionRequestConverter.toTarget(permissionRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "用户权限删除")
    @RequestMapping(value = "/deletePermission",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "用户权限删除", detail = "用户权限删除")
    public Result deletePermission(@RequestBody Set<Long> ids) {

        iPermissionService.deletePermission(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "用户权限修改")
    @RequestMapping(value = "/updatePermission",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "用户权限修改", detail = "用户权限修改")
    public Result updatePermission(@RequestBody PermissionRequest permissionRequest) {

        PermissionDTO permissionDTO = permissionRequestConverter.toTarget(permissionRequest);
        if(permissionDTO.getId() != null){
            iPermissionService.updatePermission(permissionDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "用户权限分页")
    @RequestMapping(value = "/pagerPermission",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<PermissionResponse>> getPagerResult(@RequestBody Pager<PermissionDTO> pager) {
        PagerResult<PermissionResponse> pagerResult = new PagerResult<>();
        PagerResult<PermissionDTO> dtoPagerResult = iPermissionService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(permissionResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
