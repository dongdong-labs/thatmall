package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IUserService;
import org.onedayday.admincenter.manager.converter.UserRequestConverter;
import org.onedayday.admincenter.manager.converter.UserResponseConverter;
import org.onedayday.admincenter.manager.dto.UserDTO;
import org.onedayday.admincenter.manager.request.UserRequest;
import org.onedayday.admincenter.manager.response.UserResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  UserController
* @Description: 系统用户
* @author generator
* @version 1.0
*/

@Api(tags = "系统用户")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final IUserService iUserService;

    private final UserRequestConverter userRequestConverter;

    private final UserResponseConverter userResponseConverter;

    @ApiOperation(value = "系统用户新增")
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "系统用户新增", detail = "系统用户新增")
    public Result saveUser(@RequestBody UserRequest userRequest) {
        iUserService.saveUser(userRequestConverter.toTarget(userRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "系统用户删除")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "系统用户删除", detail = "系统用户删除")
    public Result deleteUser(@RequestBody Set<Long> ids) {

        iUserService.deleteUser(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "系统用户修改")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "系统用户修改", detail = "系统用户修改")
    public Result updateUser(@RequestBody UserRequest userRequest) {

        UserDTO userDTO = userRequestConverter.toTarget(userRequest);
        if(userDTO.getId() != null){
            iUserService.updateUser(userDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "系统用户分页")
    @RequestMapping(value = "/pagerUser",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<UserResponse>> getPagerResult(@RequestBody Pager<UserDTO> pager) {
        PagerResult<UserResponse> pagerResult = new PagerResult<>();
        PagerResult<UserDTO> dtoPagerResult = iUserService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(userResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
