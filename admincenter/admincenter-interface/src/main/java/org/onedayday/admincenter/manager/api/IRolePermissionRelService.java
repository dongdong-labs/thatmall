package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.RolePermissionRelDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IRolePermissionRelService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

public interface IRolePermissionRelService{

    /**
     * 保存RolePermissionRel
     *
     * @param rolePermissionRelDTO
     * @return
     */
    int saveRolePermissionRel(RolePermissionRelDTO rolePermissionRelDTO);

    /**
     * 批量删除RolePermissionRel
     *
     * @param ids
     * @return
     */
    int deleteRolePermissionRel(Set<Long> ids);

    /**
     * 更新RolePermissionRel
     *
     * @param rolePermissionRelDTO
     * @return
     */
    int updateRolePermissionRel(RolePermissionRelDTO rolePermissionRelDTO);

    /**
     * RolePermissionRel分页
     *
     * @param pager<rolePermissionRelDTO>
     * @return
     */
    PagerResult<RolePermissionRelDTO> getPageResult(Pager<RolePermissionRelDTO> pager);

}
