package org.onedayday.admincenter.manager.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Title:  RoleMenuRelRequest
 * @Description: 角色菜单关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="RoleMenuRelRequest对象", description="角色菜单关系")
public class RoleMenuRelRequest implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 菜单ID
	*/
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;
	/**
	* 角色ID
	*/
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
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
