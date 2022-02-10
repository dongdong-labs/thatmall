package org.onedayday.goodscenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.onedayday.goodscenter.manager.api.IDeptService;
import org.onedayday.goodscenter.manager.converter.DeptRequestConverter;
import org.onedayday.goodscenter.manager.converter.DeptResponseConverter;
import org.onedayday.goodscenter.manager.dto.DeptDTO;
import org.onedayday.goodscenter.manager.request.DeptRequest;
import org.onedayday.goodscenter.manager.response.DeptResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  DeptController
* @Description: 部门
* @author generator
* @version 1.0
*/

@Api(tags = "部门")
@RestController
@RequestMapping("dept")
@RequiredArgsConstructor
public class DeptController extends BaseController {

    private final IDeptService iDeptService;

    private final DeptRequestConverter deptRequestConverter;

    private final DeptResponseConverter deptResponseConverter;

    @ApiOperation(value = "部门新增")
    @RequestMapping(value = "/saveDept",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "部门新增", detail = "部门新增")
    public Result saveDept(@RequestBody DeptRequest deptRequest) {
        iDeptService.saveDept(deptRequestConverter.toTarget(deptRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "部门删除")
    @RequestMapping(value = "/deleteDept",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "部门删除", detail = "部门删除")
    public Result deleteDept(@RequestBody Set<Long> ids) {

        iDeptService.deleteDept(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "部门修改")
    @RequestMapping(value = "/updateDept",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "部门修改", detail = "部门修改")
    public Result updateDept(@RequestBody DeptRequest deptRequest) {

        DeptDTO deptDTO = deptRequestConverter.toTarget(deptRequest);
        if(deptDTO.getId() != null){
            iDeptService.updateDept(deptDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "部门分页")
    @RequestMapping(value = "/pagerDept",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<DeptResponse>> getPagerResult(@RequestBody Pager<DeptDTO> pager) {
        PagerResult<DeptResponse> pagerResult = new PagerResult<>();
        PagerResult<DeptDTO> dtoPagerResult = iDeptService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(deptResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
