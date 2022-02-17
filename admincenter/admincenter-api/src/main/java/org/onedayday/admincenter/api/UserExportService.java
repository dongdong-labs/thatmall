package org.onedayday.admincenter.api;

import org.onedayday.admincenter.dto.UserDetailDTO;
import org.onedayday.framework.result.Result;

/**
 * @program: thatmall
 * @class: UserExportService
 * @description:
 * @author: wdd
 * @create: 2022-02-14 17:21
 */
public interface UserExportService {

    /**
     * 根据userName获取用户详细信息
     *
     * @param userName
     * @return
     */
    Result<UserDetailDTO> loadUserByUsername(String userName);

}
