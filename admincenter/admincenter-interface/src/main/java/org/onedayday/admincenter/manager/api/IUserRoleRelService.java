package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.UserRoleRelDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IUserRoleRelService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

public interface IUserRoleRelService{

    /**
     * 保存UserRoleRel
     *
     * @param userRoleRelDTO
     * @return
     */
    int saveUserRoleRel(UserRoleRelDTO userRoleRelDTO);

    /**
     * 批量删除UserRoleRel
     *
     * @param ids
     * @return
     */
    int deleteUserRoleRel(Set<Long> ids);

    /**
     * 更新UserRoleRel
     *
     * @param userRoleRelDTO
     * @return
     */
    int updateUserRoleRel(UserRoleRelDTO userRoleRelDTO);

    /**
     * UserRoleRel分页
     *
     * @param pager<userRoleRelDTO>
     * @return
     */
    PagerResult<UserRoleRelDTO> getPageResult(Pager<UserRoleRelDTO> pager);

}
