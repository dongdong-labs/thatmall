package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IUserPermissionRelService;
import org.onedayday.admincenter.manager.converter.UserPermissionRelRequestConverter;
import org.onedayday.admincenter.manager.converter.UserPermissionRelResponseConverter;
import org.onedayday.admincenter.manager.dto.UserPermissionRelDTO;
import org.onedayday.admincenter.manager.request.UserPermissionRelRequest;
import org.onedayday.admincenter.manager.response.UserPermissionRelResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  UserPermissionRelController
* @Description: 用户权限
* @author generator
* @version 1.0
*/

@Api(tags = "用户权限")
@RestController
@RequestMapping("userPermissionRel")
@RequiredArgsConstructor
public class UserPermissionRelController extends BaseController {

    private final IUserPermissionRelService iUserPermissionRelService;

    private final UserPermissionRelRequestConverter userPermissionRelRequestConverter;

    private final UserPermissionRelResponseConverter userPermissionRelResponseConverter;

    @ApiOperation(value = "用户权限新增")
    @RequestMapping(value = "/saveUserPermissionRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "用户权限新增", detail = "用户权限新增")
    public Result saveUserPermissionRel(@RequestBody UserPermissionRelRequest userPermissionRelRequest) {
        iUserPermissionRelService.saveUserPermissionRel(userPermissionRelRequestConverter.toTarget(userPermissionRelRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "用户权限删除")
    @RequestMapping(value = "/deleteUserPermissionRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "用户权限删除", detail = "用户权限删除")
    public Result deleteUserPermissionRel(@RequestBody Set<Long> ids) {

        iUserPermissionRelService.deleteUserPermissionRel(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "用户权限修改")
    @RequestMapping(value = "/updateUserPermissionRel",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "用户权限修改", detail = "用户权限修改")
    public Result updateUserPermissionRel(@RequestBody UserPermissionRelRequest userPermissionRelRequest) {

        UserPermissionRelDTO userPermissionRelDTO = userPermissionRelRequestConverter.toTarget(userPermissionRelRequest);
        if(userPermissionRelDTO.getId() != null){
            iUserPermissionRelService.updateUserPermissionRel(userPermissionRelDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "用户权限分页")
    @RequestMapping(value = "/pagerUserPermissionRel",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<UserPermissionRelResponse>> getPagerResult(@RequestBody Pager<UserPermissionRelDTO> pager) {
        PagerResult<UserPermissionRelResponse> pagerResult = new PagerResult<>();
        PagerResult<UserPermissionRelDTO> dtoPagerResult = iUserPermissionRelService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(userPermissionRelResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
