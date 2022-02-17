package org.onedayday.authoritycenter.service.entity;

import lombok.Data;
import org.onedayday.admincenter.dto.UserDetailDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 登录用户信息
 * Created by macro on 2020/6/19.
 */
@Data
public class AuthorityUserDetails implements UserDetails {

    /**
     * ID
     */
    private Long id;
    /**
     * 部门编码
     */
    private Long deptId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户状态
     */
    private Boolean enabled;
    /**
     * 登录客户端ID
     */
    private String clientId;
    /**
     * 权限数据
     */
    private Collection<SimpleGrantedAuthority> authorities;

    public AuthorityUserDetails() {

    }

    public AuthorityUserDetails(UserDetailDTO userDetailDTO) {
        this.setId(userDetailDTO.getId());
        this.setUsername(userDetailDTO.getUsername());
        this.setPassword(userDetailDTO.getPassword());
        this.setEnabled(userDetailDTO.getStatus() == 1);
        this.setClientId(userDetailDTO.getClientId());
        if (userDetailDTO.getRoleList() != null) {
            authorities = new ArrayList<>();
            userDetailDTO.getRoleList().forEach(item -> authorities.add(new SimpleGrantedAuthority(item)));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
