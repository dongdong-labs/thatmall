package org.onedayday.authoritycenter.service.impl;


import org.apache.dubbo.config.annotation.DubboReference;
import org.onedayday.admincenter.api.UserExportService;
import org.onedayday.admincenter.dto.UserDetailDTO;
import org.onedayday.authoritycenter.service.entity.AuthorityUserDetails;
import org.onedayday.framework.result.Result;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户信息
 * @author admin
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @DubboReference
    private UserExportService userExportService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<UserDetailDTO> userResult = userExportService.loadUserByUsername(username);
        if (!userResult.isSuccess() || userResult.getData() == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        AuthorityUserDetails securityUser = new AuthorityUserDetails(userResult.getData());
        if (!securityUser.isEnabled()) {
            throw new DisabledException("该账户已被禁用，请联系管理员!");
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定，请联系管理员!");
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期，请联系管理员!");
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("该账户的登录凭证已过期，请重新登录!");
        }
        return securityUser;
    }

}
