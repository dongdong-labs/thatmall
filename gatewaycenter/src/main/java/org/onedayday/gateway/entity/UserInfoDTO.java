package org.onedayday.gateway.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: gatewaycenter
 * @class: UserInfoDTO
 * @description:
 * @author: wdd
 * @create: 2022-02-13 10:53
 */
public class UserInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "所属部门ID")
    private Long deptId;

    @ApiModelProperty(value = "所属部门名称")
    private String deptName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像地址")
    private String icon;

    @ApiModelProperty(value = "状态：1启用、0禁用")
    private Boolean status;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "删除标记（1删除 0 未删除）")
    private Integer deleted;

    @ApiModelProperty(value = "版本标记")
    private Integer version;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}

