package org.onedayday.admincenter.manager.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  UserPermissionRelResponse
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="UserPermissionRelResponse对象", description="用户权限")
public class UserPermissionRelResponse implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 用户id
	*/
    @ApiModelProperty(value = "用户id")
    private Long userId;
	/**
	* 权限id
	*/
    @ApiModelProperty(value = "权限id")
    private Long permissionId;
	/**
	* 创建者
	*/
    @ApiModelProperty(value = "创建者")
    private Long createBy;
	/**
	* 更新者
	*/
    @ApiModelProperty(value = "更新者")
    private Long updateBy;
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
    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;
    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
