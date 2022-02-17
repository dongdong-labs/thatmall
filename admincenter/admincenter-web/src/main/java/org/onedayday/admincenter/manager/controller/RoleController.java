package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IRoleService;
import org.onedayday.admincenter.manager.converter.RoleRequestConverter;
import org.onedayday.admincenter.manager.converter.RoleResponseConverter;
import org.onedayday.admincenter.manager.dto.RoleDTO;
import org.onedayday.admincenter.manager.request.RoleRequest;
import org.onedayday.admincenter.manager.response.RoleResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  RoleController
* @Description: 角色表
* @author generator
* @version 1.0
*/

@Api(tags = "角色表")
@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController extends BaseController {

    private final IRoleService iRoleService;

    private final RoleRequestConverter roleRequestConverter;

    private final RoleResponseConverter roleResponseConverter;

    @ApiOperation(value = "角色表新增")
    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "角色表新增", detail = "角色表新增")
    public Result saveRole(@RequestBody RoleRequest roleRequest) {
        iRoleService.saveRole(roleRequestConverter.toTarget(roleRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "角色表删除")
    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "角色表删除", detail = "角色表删除")
    public Result deleteRole(@RequestBody Set<Long> ids) {

        iRoleService.deleteRole(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "角色表修改")
    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "角色表修改", detail = "角色表修改")
    public Result updateRole(@RequestBody RoleRequest roleRequest) {

        RoleDTO roleDTO = roleRequestConverter.toTarget(roleRequest);
        if(roleDTO.getId() != null){
            iRoleService.updateRole(roleDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "角色表分页")
    @RequestMapping(value = "/pagerRole",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<RoleResponse>> getPagerResult(@RequestBody Pager<RoleDTO> pager) {
        PagerResult<RoleResponse> pagerResult = new PagerResult<>();
        PagerResult<RoleDTO> dtoPagerResult = iRoleService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(roleResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
