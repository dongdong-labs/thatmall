package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.RoleDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IRoleService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

public interface IRoleService{

    /**
     * 保存Role
     *
     * @param roleDTO
     * @return
     */
    int saveRole(RoleDTO roleDTO);

    /**
     * 批量删除Role
     *
     * @param ids
     * @return
     */
    int deleteRole(Set<Long> ids);

    /**
     * 更新Role
     *
     * @param roleDTO
     * @return
     */
    int updateRole(RoleDTO roleDTO);

    /**
     * Role分页
     *
     * @param pager<roleDTO>
     * @return
     */
    PagerResult<RoleDTO> getPageResult(Pager<RoleDTO> pager);

}
