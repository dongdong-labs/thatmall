package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.RoleMenuRelDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IRoleMenuRelService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

public interface IRoleMenuRelService{

    /**
     * 保存RoleMenuRel
     *
     * @param roleMenuRelDTO
     * @return
     */
    int saveRoleMenuRel(RoleMenuRelDTO roleMenuRelDTO);

    /**
     * 批量删除RoleMenuRel
     *
     * @param ids
     * @return
     */
    int deleteRoleMenuRel(Set<Long> ids);

    /**
     * 更新RoleMenuRel
     *
     * @param roleMenuRelDTO
     * @return
     */
    int updateRoleMenuRel(RoleMenuRelDTO roleMenuRelDTO);

    /**
     * RoleMenuRel分页
     *
     * @param pager<roleMenuRelDTO>
     * @return
     */
    PagerResult<RoleMenuRelDTO> getPageResult(Pager<RoleMenuRelDTO> pager);

}
