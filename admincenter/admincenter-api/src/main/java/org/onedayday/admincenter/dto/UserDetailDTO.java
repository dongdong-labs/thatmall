package org.onedayday.admincenter.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: thatmall
 * @class: UserDTO
 * @description:
 * @author: wdd
 * @create: 2022-02-14 17:23
 */
@Data
public class UserDetailDTO implements Serializable {
    /**
     * ID
     */
    private Long id;
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
    private Integer status;

    /**
     * 登录客户端ID
     */
    private String clientId;

    /**
     * 权限编码
     */
    private List<String> roleList;
}
