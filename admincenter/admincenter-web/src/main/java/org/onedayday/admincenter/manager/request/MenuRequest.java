package org.onedayday.admincenter.manager.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Title:  MenuRequest
 * @Description: 系统菜单
 * @author generator
 * @date 2022-02-14 14:46:58
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="MenuRequest对象", description="系统菜单")
public class MenuRequest implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 上级菜单ID
	*/
    @ApiModelProperty(value = "上级菜单ID")
    private Long pid;
	/**
	* 菜单类型
	*/
    @ApiModelProperty(value = "菜单类型")
    private Integer type;
	/**
	* 菜单标题
	*/
    @ApiModelProperty(value = "菜单标题")
    private String title;
	/**
	* 前端名称
	*/
    @ApiModelProperty(value = "前端名称")
    private String name;
	/**
	* 排序
	*/
    @ApiModelProperty(value = "排序")
    private Integer sort;
	/**
	* 菜单级数
	*/
    @ApiModelProperty(value = "菜单级数")
    private Integer level;
	/**
	* 图标
	*/
    @ApiModelProperty(value = "图标")
    private String icon;
	/**
	* 缓存
	*/
    @ApiModelProperty(value = "缓存")
    private Boolean cache;
	/**
	* 隐藏
	*/
    @ApiModelProperty(value = "隐藏")
    private Boolean hidden;
	
}
