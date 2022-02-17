package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IRolePermissionRelService;
import org.onedayday.admincenter.manager.converter.RolePermissionRelDTOConverter;
import org.onedayday.admincenter.manager.dto.RolePermissionRelDTO;
import org.onedayday.admincenter.repository.mapper.RolePermissionRelMapper;
import org.onedayday.admincenter.repository.po.RolePermissionRel;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  RolePermissionRelServiceImpl
 * @Description: 角色资源关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Service("rolePermissionRelService")
@RequiredArgsConstructor
@Slf4j
public class RolePermissionRelServiceImpl  implements IRolePermissionRelService {

    private final RolePermissionRelMapper rolePermissionRelMapper;

    private final RolePermissionRelDTOConverter rolePermissionRelDTOConverter;

    /**
     * 保存RolePermissionRel
     *
     * @param rolePermissionRelDTO
     * @return
     */
    @Override
    public int saveRolePermissionRel(RolePermissionRelDTO rolePermissionRelDTO) {
        return  rolePermissionRelMapper.insert(rolePermissionRelDTOConverter.toSource(rolePermissionRelDTO));
    }

    /**
     * 批量删除RolePermissionRel
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteRolePermissionRel(Set<Long> ids) {
        return rolePermissionRelMapper.deleteBatchIds(ids);
    }

    /**
     * 更新RolePermissionRel
     *
     * @param rolePermissionRelDTO
     * @return
     */
    @Override
    public int updateRolePermissionRel(RolePermissionRelDTO rolePermissionRelDTO) {
        return rolePermissionRelMapper.updateById(rolePermissionRelDTOConverter.toSource(rolePermissionRelDTO));
    }

    /**
     * RolePermissionRel分页
     *
     * @param pager<rolePermissionRelDTO>
     * @return
     */
    @Override
    public  PagerResult<RolePermissionRelDTO> getPageResult(Pager<RolePermissionRelDTO> pager) {
        QueryWrapper<RolePermissionRel > queryWrapper = new QueryWrapper<>();
        Page<RolePermissionRel> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<RolePermissionRel> iPage = rolePermissionRelMapper.selectPage(page,queryWrapper);
        PagerResult<RolePermissionRelDTO> result = new PagerResult<>();
        result.setList(rolePermissionRelDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
