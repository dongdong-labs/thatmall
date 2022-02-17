package org.onedayday.admincenter.manager.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  MenuDTO
 * @Description: 系统菜单
 * @author generator
 * @date 2022-02-14 14:46:58
 * @version 1.0
 */
@Data
@ToString
public class MenuDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

	/**
	* 上级菜单ID
	*/
    private Long pid;
	/**
	* 菜单类型
	*/
    private Integer type;
	/**
	* 菜单标题
	*/
    private String title;
	/**
	* 前端名称
	*/
    private String name;
	/**
	* 排序
	*/
    private Integer sort;
	/**
	* 菜单级数
	*/
    private Integer level;
	/**
	* 图标
	*/
    private String icon;
	/**
	* 缓存
	*/
    private Boolean cache;
	/**
	* 隐藏
	*/
    private Boolean hidden;
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
