package org.onedayday.admincenter.manager.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Title:  UserPermissionRelRequest
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="UserPermissionRelRequest对象", description="用户权限")
public class UserPermissionRelRequest implements Serializable {

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
	
}
