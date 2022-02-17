package org.onedayday.admincenter.manager.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  RoleMenuRelDTO
 * @Description: 角色菜单关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
public class RoleMenuRelDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

	/**
	* 菜单ID
	*/
    private Long menuId;
	/**
	* 角色ID
	*/
    private Long roleId;
	/**
	* 创建者
	*/
    private Long createBy;
	/**
	* 更新者
	*/
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
    private Date modifyTime;
    /**
    * 创建时间
    */
    private Date createTime;
}
