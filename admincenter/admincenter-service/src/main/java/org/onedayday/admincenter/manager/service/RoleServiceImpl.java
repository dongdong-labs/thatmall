package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IRoleService;
import org.onedayday.admincenter.manager.converter.RoleDTOConverter;
import org.onedayday.admincenter.manager.dto.RoleDTO;
import org.onedayday.admincenter.repository.mapper.RoleMapper;
import org.onedayday.admincenter.repository.po.Role;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  RoleServiceImpl
 * @Description: 角色表
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Service("roleService")
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl  implements IRoleService {

    private final RoleMapper roleMapper;

    private final RoleDTOConverter roleDTOConverter;

    /**
     * 保存Role
     *
     * @param roleDTO
     * @return
     */
    @Override
    public int saveRole(RoleDTO roleDTO) {
        return  roleMapper.insert(roleDTOConverter.toSource(roleDTO));
    }

    /**
     * 批量删除Role
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteRole(Set<Long> ids) {
        return roleMapper.deleteBatchIds(ids);
    }

    /**
     * 更新Role
     *
     * @param roleDTO
     * @return
     */
    @Override
    public int updateRole(RoleDTO roleDTO) {
        return roleMapper.updateById(roleDTOConverter.toSource(roleDTO));
    }

    /**
     * Role分页
     *
     * @param pager<roleDTO>
     * @return
     */
    @Override
    public  PagerResult<RoleDTO> getPageResult(Pager<RoleDTO> pager) {
        QueryWrapper<Role > queryWrapper = new QueryWrapper<>();
        Page<Role> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<Role> iPage = roleMapper.selectPage(page,queryWrapper);
        PagerResult<RoleDTO> result = new PagerResult<>();
        result.setList(roleDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
