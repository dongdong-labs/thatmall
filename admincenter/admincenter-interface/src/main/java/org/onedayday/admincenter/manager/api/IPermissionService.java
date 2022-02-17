package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.PermissionDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IPermissionService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

public interface IPermissionService{

    /**
     * 保存Permission
     *
     * @param permissionDTO
     * @return
     */
    int savePermission(PermissionDTO permissionDTO);

    /**
     * 批量删除Permission
     *
     * @param ids
     * @return
     */
    int deletePermission(Set<Long> ids);

    /**
     * 更新Permission
     *
     * @param permissionDTO
     * @return
     */
    int updatePermission(PermissionDTO permissionDTO);

    /**
     * Permission分页
     *
     * @param pager<permissionDTO>
     * @return
     */
    PagerResult<PermissionDTO> getPageResult(Pager<PermissionDTO> pager);

}
