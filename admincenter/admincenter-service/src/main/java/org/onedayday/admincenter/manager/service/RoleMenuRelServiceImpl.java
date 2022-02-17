package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IRoleMenuRelService;
import org.onedayday.admincenter.manager.converter.RoleMenuRelDTOConverter;
import org.onedayday.admincenter.manager.dto.RoleMenuRelDTO;
import org.onedayday.admincenter.repository.mapper.RoleMenuRelMapper;
import org.onedayday.admincenter.repository.po.RoleMenuRel;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  RoleMenuRelServiceImpl
 * @Description: 角色菜单关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Service("roleMenuRelService")
@RequiredArgsConstructor
@Slf4j
public class RoleMenuRelServiceImpl  implements IRoleMenuRelService {

    private final RoleMenuRelMapper roleMenuRelMapper;

    private final RoleMenuRelDTOConverter roleMenuRelDTOConverter;

    /**
     * 保存RoleMenuRel
     *
     * @param roleMenuRelDTO
     * @return
     */
    @Override
    public int saveRoleMenuRel(RoleMenuRelDTO roleMenuRelDTO) {
        return  roleMenuRelMapper.insert(roleMenuRelDTOConverter.toSource(roleMenuRelDTO));
    }

    /**
     * 批量删除RoleMenuRel
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteRoleMenuRel(Set<Long> ids) {
        return roleMenuRelMapper.deleteBatchIds(ids);
    }

    /**
     * 更新RoleMenuRel
     *
     * @param roleMenuRelDTO
     * @return
     */
    @Override
    public int updateRoleMenuRel(RoleMenuRelDTO roleMenuRelDTO) {
        return roleMenuRelMapper.updateById(roleMenuRelDTOConverter.toSource(roleMenuRelDTO));
    }

    /**
     * RoleMenuRel分页
     *
     * @param pager<roleMenuRelDTO>
     * @return
     */
    @Override
    public  PagerResult<RoleMenuRelDTO> getPageResult(Pager<RoleMenuRelDTO> pager) {
        QueryWrapper<RoleMenuRel > queryWrapper = new QueryWrapper<>();
        Page<RoleMenuRel> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<RoleMenuRel> iPage = roleMenuRelMapper.selectPage(page,queryWrapper);
        PagerResult<RoleMenuRelDTO> result = new PagerResult<>();
        result.setList(roleMenuRelDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
