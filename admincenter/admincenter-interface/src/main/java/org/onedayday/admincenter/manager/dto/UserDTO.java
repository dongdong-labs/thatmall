package org.onedayday.admincenter.manager.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Title:  UserDTO
 * @Description: 系统用户
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

	/**
	* 用户名
	*/
    private String userName;
	/**
	* 昵称
	*/
    private String nickName;
	/**
	* 手机号码
	*/
    private String phone;
	/**
	* 邮箱
	*/
    private String email;
	/**
	* 微信openId
	*/
    private String openId;
	/**
	* 微信unionId
	*/
    private String unionId;
	/**
	* 头像地址
	*/
    private String icon;
	/**
	* 密码
	*/
    private String password;
	/**
	* 性别
	*/
    private String gender;
	/**
	* 出生日期
	*/
    private Timestamp birthday;
	/**
	* 盐
	*/
    private String salt;
	/**
	* 状态：1启用、0禁用
	*/
    private Boolean status;
    /**
    * 删除标记
    */
    private Integer deleted;
    /**
    * 版本号
    */
    private Integer version;
    /**
    * 更新时间
    */
    private Date modifyTime;
    /**
    * 创建时间
    */
    private Date createTime;
}
