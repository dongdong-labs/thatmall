package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IUserRoleRelService;
import org.onedayday.admincenter.manager.converter.UserRoleRelRequestConverter;
import org.onedayday.admincenter.manager.converter.UserRoleRelResponseConverter;
import org.onedayday.admincenter.manager.dto.UserRoleRelDTO;
import org.onedayday.admincenter.manager.request.UserRoleRelRequest;
import org.onedayday.admincenter.manager.response.UserRoleRelResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  UserRoleRelController
* @Description: 用户角色
* @author generator
* @version 1.0
*/

@Api(tags = "用户角色")
@RestController
@RequestMapping("userRoleRel")
@RequiredArgsConstructor
public class UserRoleRelController extends BaseController {

    private final IUserRoleRelService iUserRoleRelService;

    private final UserRoleRelRequestConverter userRoleRelRequestConverter;

    private final UserRoleRelResponseConverter userRoleRelResponseConverter;

    @ApiOperation(value = "用户角色新增")
    @RequestMapping(value = "/saveUserRoleRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "用户角色新增", detail = "用户角色新增")
    public Result saveUserRoleRel(@RequestBody UserRoleRelRequest userRoleRelRequest) {
        iUserRoleRelService.saveUserRoleRel(userRoleRelRequestConverter.toTarget(userRoleRelRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "用户角色删除")
    @RequestMapping(value = "/deleteUserRoleRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "用户角色删除", detail = "用户角色删除")
    public Result deleteUserRoleRel(@RequestBody Set<Long> ids) {

        iUserRoleRelService.deleteUserRoleRel(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "用户角色修改")
    @RequestMapping(value = "/updateUserRoleRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "用户角色修改", detail = "用户角色修改")
    public Result updateUserRoleRel(@RequestBody UserRoleRelRequest userRoleRelRequest) {

        UserRoleRelDTO userRoleRelDTO = userRoleRelRequestConverter.toTarget(userRoleRelRequest);
        if(userRoleRelDTO.getId() != null){
            iUserRoleRelService.updateUserRoleRel(userRoleRelDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "用户角色分页")
    @RequestMapping(value = "/pagerUserRoleRel",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<UserRoleRelResponse>> getPagerResult(@RequestBody Pager<UserRoleRelDTO> pager) {
        PagerResult<UserRoleRelResponse> pagerResult = new PagerResult<>();
        PagerResult<UserRoleRelDTO> dtoPagerResult = iUserRoleRelService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(userRoleRelResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
