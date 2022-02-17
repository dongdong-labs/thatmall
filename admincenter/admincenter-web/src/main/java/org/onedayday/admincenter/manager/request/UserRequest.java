package org.onedayday.admincenter.manager.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Title:  UserRequest
 * @Description: 系统用户
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="UserRequest对象", description="系统用户")
public class UserRequest implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 用户名
	*/
    @ApiModelProperty(value = "用户名")
    private String userName;
	/**
	* 昵称
	*/
    @ApiModelProperty(value = "昵称")
    private String nickName;
	/**
	* 手机号码
	*/
    @ApiModelProperty(value = "手机号码")
    private String phone;
	/**
	* 邮箱
	*/
    @ApiModelProperty(value = "邮箱")
    private String email;
	/**
	* 微信openId
	*/
    @ApiModelProperty(value = "微信openId")
    private String openId;
	/**
	* 微信unionId
	*/
    @ApiModelProperty(value = "微信unionId")
    private String unionId;
	/**
	* 头像地址
	*/
    @ApiModelProperty(value = "头像地址")
    private String icon;
	/**
	* 密码
	*/
    @ApiModelProperty(value = "密码")
    private String password;
	/**
	* 性别
	*/
    @ApiModelProperty(value = "性别")
    private String gender;
	/**
	* 出生日期
	*/
    @ApiModelProperty(value = "出生日期")
    private Timestamp birthday;
	/**
	* 盐
	*/
    @ApiModelProperty(value = "盐")
    private String salt;
	/**
	* 状态：1启用、0禁用
	*/
    @ApiModelProperty(value = "状态：1启用、0禁用")
    private Boolean status;
	
}
