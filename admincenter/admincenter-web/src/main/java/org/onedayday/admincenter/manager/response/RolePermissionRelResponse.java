package org.onedayday.admincenter.manager.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  RolePermissionRelResponse
 * @Description: 角色资源关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="RolePermissionRelResponse对象", description="角色资源关系")
public class RolePermissionRelResponse implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 菜单ID
	*/
    @ApiModelProperty(value = "菜单ID")
    private Long permissionId;
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
