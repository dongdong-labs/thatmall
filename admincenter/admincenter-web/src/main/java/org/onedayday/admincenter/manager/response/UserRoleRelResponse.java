package org.onedayday.admincenter.manager.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  UserRoleRelResponse
 * @Description: 用户角色
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="UserRoleRelResponse对象", description="用户角色")
public class UserRoleRelResponse implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 用户id
	*/
    @ApiModelProperty(value = "用户id")
    private Long userId;
	/**
	* 角色Id
	*/
    @ApiModelProperty(value = "角色Id")
    private Long roleId;
	/**
	* 记录类型 1 用户自己创建时添加 2 上级分配时添加
	*/
    @ApiModelProperty(value = "记录类型 1 用户自己创建时添加 2 上级分配时添加")
    private Integer type;
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
