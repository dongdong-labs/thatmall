package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.UserPermissionRelDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IUserPermissionRelService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

public interface IUserPermissionRelService{

    /**
     * 保存UserPermissionRel
     *
     * @param userPermissionRelDTO
     * @return
     */
    int saveUserPermissionRel(UserPermissionRelDTO userPermissionRelDTO);

    /**
     * 批量删除UserPermissionRel
     *
     * @param ids
     * @return
     */
    int deleteUserPermissionRel(Set<Long> ids);

    /**
     * 更新UserPermissionRel
     *
     * @param userPermissionRelDTO
     * @return
     */
    int updateUserPermissionRel(UserPermissionRelDTO userPermissionRelDTO);

    /**
     * UserPermissionRel分页
     *
     * @param pager<userPermissionRelDTO>
     * @return
     */
    PagerResult<UserPermissionRelDTO> getPageResult(Pager<UserPermissionRelDTO> pager);

}
