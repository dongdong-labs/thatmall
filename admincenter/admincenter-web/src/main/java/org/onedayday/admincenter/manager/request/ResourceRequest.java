package org.onedayday.admincenter.manager.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Title:  ResourceRequest
 * @Description: 后台资源
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="ResourceRequest对象", description="后台资源")
public class ResourceRequest implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 资源名称
	*/
    @ApiModelProperty(value = "资源名称")
    private String name;
	/**
	* 资源URL
	*/
    @ApiModelProperty(value = "资源URL")
    private String url;
	/**
	* 描述
	*/
    @ApiModelProperty(value = "描述")
    private String description;
	/**
	* 资源分类ID
	*/
    @ApiModelProperty(value = "资源分类ID")
    private Long categoryId;
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
	* 资源分类
	*/
    @ApiModelProperty(value = "资源分类")
    private String categoryName;
	
}
