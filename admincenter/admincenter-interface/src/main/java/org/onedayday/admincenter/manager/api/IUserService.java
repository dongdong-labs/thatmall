package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.UserDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IUserService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

public interface IUserService{

    /**
     * 保存User
     *
     * @param userDTO
     * @return
     */
    int saveUser(UserDTO userDTO);

    /**
     * 批量删除User
     *
     * @param ids
     * @return
     */
    int deleteUser(Set<Long> ids);

    /**
     * 更新User
     *
     * @param userDTO
     * @return
     */
    int updateUser(UserDTO userDTO);

    /**
     * User分页
     *
     * @param pager<userDTO>
     * @return
     */
    PagerResult<UserDTO> getPageResult(Pager<UserDTO> pager);

}
