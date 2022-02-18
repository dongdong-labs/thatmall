package org.onedayday.admincenter.manager.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.onedayday.admincenter.api.UserExportService;
import org.onedayday.admincenter.dto.UserDetailDTO;
import org.onedayday.framework.result.Result;

/**
 * @program: thatmall
 * @class: UserExportServiceImpl
 * @description:
 * @author: wdd
 * @create: 2022-02-18 10:17
 */
@DubboService
public class UserExportServiceImpl implements UserExportService {
    /**
     * 根据userName获取用户详细信息
     *
     * @param userName
     * @return
     */
    @Override
    public Result<UserDetailDTO> loadUserByUsername(String userName) {
        return null;
    }
}
