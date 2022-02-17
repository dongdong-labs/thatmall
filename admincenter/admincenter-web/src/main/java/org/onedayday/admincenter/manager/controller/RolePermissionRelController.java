package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IRolePermissionRelService;
import org.onedayday.admincenter.manager.converter.RolePermissionRelRequestConverter;
import org.onedayday.admincenter.manager.converter.RolePermissionRelResponseConverter;
import org.onedayday.admincenter.manager.dto.RolePermissionRelDTO;
import org.onedayday.admincenter.manager.request.RolePermissionRelRequest;
import org.onedayday.admincenter.manager.response.RolePermissionRelResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  RolePermissionRelController
* @Description: 角色资源关系
* @author generator
* @version 1.0
*/

@Api(tags = "角色资源关系")
@RestController
@RequestMapping("rolePermissionRel")
@RequiredArgsConstructor
public class RolePermissionRelController extends BaseController {

    private final IRolePermissionRelService iRolePermissionRelService;

    private final RolePermissionRelRequestConverter rolePermissionRelRequestConverter;

    private final RolePermissionRelResponseConverter rolePermissionRelResponseConverter;

    @ApiOperation(value = "角色资源关系新增")
    @RequestMapping(value = "/saveRolePermissionRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "角色资源关系新增", detail = "角色资源关系新增")
    public Result saveRolePermissionRel(@RequestBody RolePermissionRelRequest rolePermissionRelRequest) {
        iRolePermissionRelService.saveRolePermissionRel(rolePermissionRelRequestConverter.toTarget(rolePermissionRelRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "角色资源关系删除")
    @RequestMapping(value = "/deleteRolePermissionRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "角色资源关系删除", detail = "角色资源关系删除")
    public Result deleteRolePermissionRel(@RequestBody Set<Long> ids) {

        iRolePermissionRelService.deleteRolePermissionRel(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "角色资源关系修改")
    @RequestMapping(value = "/updateRolePermissionRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "角色资源关系修改", detail = "角色资源关系修改")
    public Result updateRolePermissionRel(@RequestBody RolePermissionRelRequest rolePermissionRelRequest) {

        RolePermissionRelDTO rolePermissionRelDTO = rolePermissionRelRequestConverter.toTarget(rolePermissionRelRequest);
        if(rolePermissionRelDTO.getId() != null){
            iRolePermissionRelService.updateRolePermissionRel(rolePermissionRelDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "角色资源关系分页")
    @RequestMapping(value = "/pagerRolePermissionRel",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<RolePermissionRelResponse>> getPagerResult(@RequestBody Pager<RolePermissionRelDTO> pager) {
        PagerResult<RolePermissionRelResponse> pagerResult = new PagerResult<>();
        PagerResult<RolePermissionRelDTO> dtoPagerResult = iRolePermissionRelService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(rolePermissionRelResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
