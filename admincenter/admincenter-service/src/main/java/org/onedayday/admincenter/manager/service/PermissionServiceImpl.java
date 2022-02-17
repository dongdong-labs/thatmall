package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IPermissionService;
import org.onedayday.admincenter.manager.converter.PermissionDTOConverter;
import org.onedayday.admincenter.manager.dto.PermissionDTO;
import org.onedayday.admincenter.repository.mapper.PermissionMapper;
import org.onedayday.admincenter.repository.po.Permission;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  PermissionServiceImpl
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Service("permissionService")
@RequiredArgsConstructor
@Slf4j
public class PermissionServiceImpl  implements IPermissionService {

    private final PermissionMapper permissionMapper;

    private final PermissionDTOConverter permissionDTOConverter;

    /**
     * 保存Permission
     *
     * @param permissionDTO
     * @return
     */
    @Override
    public int savePermission(PermissionDTO permissionDTO) {
        return  permissionMapper.insert(permissionDTOConverter.toSource(permissionDTO));
    }

    /**
     * 批量删除Permission
     *
     * @param ids
     * @return
     */
    @Override
    public int deletePermission(Set<Long> ids) {
        return permissionMapper.deleteBatchIds(ids);
    }

    /**
     * 更新Permission
     *
     * @param permissionDTO
     * @return
     */
    @Override
    public int updatePermission(PermissionDTO permissionDTO) {
        return permissionMapper.updateById(permissionDTOConverter.toSource(permissionDTO));
    }

    /**
     * Permission分页
     *
     * @param pager<permissionDTO>
     * @return
     */
    @Override
    public  PagerResult<PermissionDTO> getPageResult(Pager<PermissionDTO> pager) {
        QueryWrapper<Permission > queryWrapper = new QueryWrapper<>();
        Page<Permission> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<Permission> iPage = permissionMapper.selectPage(page,queryWrapper);
        PagerResult<PermissionDTO> result = new PagerResult<>();
        result.setList(permissionDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
