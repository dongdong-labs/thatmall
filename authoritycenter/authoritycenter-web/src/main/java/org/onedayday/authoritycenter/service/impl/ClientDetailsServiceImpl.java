package org.onedayday.authoritycenter.service.impl;


import org.apache.dubbo.config.annotation.DubboReference;
import org.onedayday.admincenter.api.ClientExportService;
import org.onedayday.admincenter.dto.ClientDetailDTO;
import org.onedayday.framework.result.Result;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 客户端信息
 * @author admin
 */
@Service("clientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @DubboReference
    private  ClientExportService clientExportService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        Result<ClientDetailDTO> result = clientExportService.loadClientByClientId(clientId);
        if (result.isSuccess() && result.getData() != null) {
            ClientDetailDTO client = result.getData();
            BaseClientDetails clientDetails = new BaseClientDetails(
                    client.getClientId(),
                    client.getResourceIds(),
                    client.getScope(),
                    client.getAuthorizedGrantTypes(),
                    client.getAuthorities(),
                    client.getWebServerRedirectUri()
            );
            clientDetails.setClientSecret(client.getClientSecret());
            clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
            clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
            return clientDetails;
        } else {
            throw new NoSuchClientException("No Such Client with clientid:" + clientId);
        }
    }
}
