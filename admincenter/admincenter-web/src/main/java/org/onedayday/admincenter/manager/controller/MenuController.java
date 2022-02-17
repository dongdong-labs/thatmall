package org.onedayday.admincenter.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.onedayday.admincenter.manager.api.IMenuService;
import org.onedayday.admincenter.manager.converter.MenuRequestConverter;
import org.onedayday.admincenter.manager.converter.MenuResponseConverter;
import org.onedayday.admincenter.manager.dto.MenuDTO;
import org.onedayday.admincenter.manager.request.MenuRequest;
import org.onedayday.admincenter.manager.response.MenuResponse;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.enums.BehaviorEnum;
import org.onedayday.framework.manager.controller.BaseController;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.framework.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
* @Title:  MenuController
* @Description: 系统菜单
* @author generator
* @version 1.0
*/

@Api(tags = "系统菜单")
@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController extends BaseController {

    private final IMenuService iMenuService;

    private final MenuRequestConverter menuRequestConverter;

    private final MenuResponseConverter menuResponseConverter;

    @ApiOperation(value = "系统菜单新增")
    @RequestMapping(value = "/saveMenu",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.SAVE, object = "系统菜单新增", detail = "系统菜单新增")
    public Result saveMenu(@RequestBody MenuRequest menuRequest) {
        iMenuService.saveMenu(menuRequestConverter.toTarget(menuRequest));
        return Result.success("执行成功！");
    }

    @ApiOperation(value = "系统菜单删除")
    @RequestMapping(value = "/deleteMenu",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.DELETE, object = "系统菜单删除", detail = "系统菜单删除")
    public Result deleteMenu(@RequestBody Set<Long> ids) {

        iMenuService.deleteMenu(ids);
        return Result.success("删除成功！");
    }

    @ApiOperation(value = "系统菜单修改")
    @RequestMapping(value = "/updateMenu",method = RequestMethod.POST)
    @AuditLog(behavior = BehaviorEnum.UPDATE, object = "系统菜单修改", detail = "系统菜单修改")
    public Result updateMenu(@RequestBody MenuRequest menuRequest) {

        MenuDTO menuDTO = menuRequestConverter.toTarget(menuRequest);
        if(menuDTO.getId() != null){
            iMenuService.updateMenu(menuDTO);
        }
        return Result.success("执行成功！");
    }


    @ApiOperation(value = "系统菜单分页")
    @RequestMapping(value = "/pagerMenu",method = RequestMethod.POST)
    @ResponseBody
    public Result<PagerResult<MenuResponse>> getPagerResult(@RequestBody Pager<MenuDTO> pager) {
        PagerResult<MenuResponse> pagerResult = new PagerResult<>();
        PagerResult<MenuDTO> dtoPagerResult = iMenuService.getPageResult(pager);
        pagerResult.setTotal(dtoPagerResult.getTotal());
        pagerResult.setList(menuResponseConverter.toSourceList(dtoPagerResult.getList()));
        return  Result.data(pagerResult);
    }

}
