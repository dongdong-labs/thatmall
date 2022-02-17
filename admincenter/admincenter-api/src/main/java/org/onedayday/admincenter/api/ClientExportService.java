package org.onedayday.admincenter.api;

import org.onedayday.admincenter.dto.ClientDetailDTO;
import org.onedayday.framework.result.Result;

/**
 * @program: thatmall
 * @class: ClientExportService
 * @description:
 * @author: wdd
 * @create: 2022-02-15 12:29
 */
public interface ClientExportService {
    Result<ClientDetailDTO> loadClientByClientId(String clientId);
}
