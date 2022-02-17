package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IRoleMenuRelService;
import org.onedayday.admincenter.manager.converter.RoleMenuRelRequestConverter;
import org.onedayday.admincenter.manager.converter.RoleMenuRelResponseConverter;
import org.onedayday.admincenter.manager.dto.RoleMenuRelDTO;
import org.onedayday.admincenter.manager.request.RoleMenuRelRequest;
import org.onedayday.admincenter.manager.response.RoleMenuRelResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  RoleMenuRelController
* @Description: 角色菜单关系
* @author generator
* @version 1.0
*/

@Api(tags = "角色菜单关系")
@RestController
@RequestMapping("roleMenuRel")
@RequiredArgsConstructor
public class RoleMenuRelController extends BaseController {

    private final IRoleMenuRelService iRoleMenuRelService;

    private final RoleMenuRelRequestConverter roleMenuRelRequestConverter;

    private final RoleMenuRelResponseConverter roleMenuRelResponseConverter;

    @ApiOperation(value = "角色菜单关系新增")
    @RequestMapping(value = "/saveRoleMenuRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "角色菜单关系新增", detail = "角色菜单关系新增")
    public Result saveRoleMenuRel(@RequestBody RoleMenuRelRequest roleMenuRelRequest) {
        iRoleMenuRelService.saveRoleMenuRel(roleMenuRelRequestConverter.toTarget(roleMenuRelRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "角色菜单关系删除")
    @RequestMapping(value = "/deleteRoleMenuRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "角色菜单关系删除", detail = "角色菜单关系删除")
    public Result deleteRoleMenuRel(@RequestBody Set<Long> ids) {

        iRoleMenuRelService.deleteRoleMenuRel(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "角色菜单关系修改")
    @RequestMapping(value = "/updateRoleMenuRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "角色菜单关系修改", detail = "角色菜单关系修改")
    public Result updateRoleMenuRel(@RequestBody RoleMenuRelRequest roleMenuRelRequest) {

        RoleMenuRelDTO roleMenuRelDTO = roleMenuRelRequestConverter.toTarget(roleMenuRelRequest);
        if(roleMenuRelDTO.getId() != null){
            iRoleMenuRelService.updateRoleMenuRel(roleMenuRelDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "角色菜单关系分页")
    @RequestMapping(value = "/pagerRoleMenuRel",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<RoleMenuRelResponse>> getPagerResult(@RequestBody Pager<RoleMenuRelDTO> pager) {
        PagerResult<RoleMenuRelResponse> pagerResult = new PagerResult<>();
        PagerResult<RoleMenuRelDTO> dtoPagerResult = iRoleMenuRelService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(roleMenuRelResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
