package org.onedayday.admincenter.manager.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.onedayday.admincenter.api.ClientExportService;
import org.onedayday.admincenter.dto.ClientDetailDTO;
import org.onedayday.framework.result.Result;

/**
 * @program: thatmall
 * @class: ClientExportServiceImpl
 * @description:
 * @author: wdd
 * @create: 2022-02-18 10:17
 */
@DubboService
public class ClientExportServiceImpl implements ClientExportService {
    @Override
    public Result<ClientDetailDTO> loadClientByClientId(String clientId) {
        return null;
    }
}
