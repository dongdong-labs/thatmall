package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IResourceService;
import org.onedayday.admincenter.manager.converter.ResourceRequestConverter;
import org.onedayday.admincenter.manager.converter.ResourceResponseConverter;
import org.onedayday.admincenter.manager.dto.ResourceDTO;
import org.onedayday.admincenter.manager.request.ResourceRequest;
import org.onedayday.admincenter.manager.response.ResourceResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  ResourceController
* @Description: 后台资源
* @author generator
* @version 1.0
*/

@Api(tags = "后台资源")
@RestController
@RequestMapping("resource")
@RequiredArgsConstructor
public class ResourceController extends BaseController {

    private final IResourceService iResourceService;

    private final ResourceRequestConverter resourceRequestConverter;

    private final ResourceResponseConverter resourceResponseConverter;

    @ApiOperation(value = "后台资源新增")
    @RequestMapping(value = "/saveResource",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "后台资源新增", detail = "后台资源新增")
    public Result saveResource(@RequestBody ResourceRequest resourceRequest) {
        iResourceService.saveResource(resourceRequestConverter.toTarget(resourceRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "后台资源删除")
    @RequestMapping(value = "/deleteResource",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "后台资源删除", detail = "后台资源删除")
    public Result deleteResource(@RequestBody Set<Long> ids) {

        iResourceService.deleteResource(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "后台资源修改")
    @RequestMapping(value = "/updateResource",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "后台资源修改", detail = "后台资源修改")
    public Result updateResource(@RequestBody ResourceRequest resourceRequest) {

        ResourceDTO resourceDTO = resourceRequestConverter.toTarget(resourceRequest);
        if(resourceDTO.getId() != null){
            iResourceService.updateResource(resourceDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "后台资源分页")
    @RequestMapping(value = "/pagerResource",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<ResourceResponse>> getPagerResult(@RequestBody Pager<ResourceDTO> pager) {
        PagerResult<ResourceResponse> pagerResult = new PagerResult<>();
        PagerResult<ResourceDTO> dtoPagerResult = iResourceService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(resourceResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
