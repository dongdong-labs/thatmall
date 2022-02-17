package org.onedayday.admincenter.manager.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  PermissionDTO
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
public class PermissionDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

	/**
	* 父级权限id
	*/
    private Long pid;
	/**
	* 名称
	*/
    private String name;
	/**
	* 权限值
	*/
    private String value;
	/**
	* 图标
	*/
    private String icon;
	/**
	* 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
	*/
    private Integer type;
	/**
	* 前端资源路径
	*/
    private String uri;
	/**
	* 启用状态；0->禁用；1->启用
	*/
    private Integer status;
	/**
	* 排序
	*/
    private Integer sort;
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
