package org.onedayday.admincenter.manager.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  RoleDTO
 * @Description: 角色表
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

	/**
	* 名称
	*/
    private String name;
	/**
	* 角色级别
	*/
    private Integer level;
	/**
	* 描述
	*/
    private String description;
	/**
	* 启用状态；0->禁用；1->启用
	*/
    private Integer status;
	/**
	* 角色类型：1：系统内置 2：用户创建
	*/
    private Integer type;
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
