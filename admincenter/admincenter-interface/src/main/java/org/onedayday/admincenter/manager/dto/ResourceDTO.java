package org.onedayday.admincenter.manager.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  ResourceDTO
 * @Description: 后台资源
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
public class ResourceDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

	/**
	* 资源名称
	*/
    private String name;
	/**
	* 资源URL
	*/
    private String url;
	/**
	* 描述
	*/
    private String description;
	/**
	* 资源分类ID
	*/
    private Long categoryId;
	/**
	* 创建者
	*/
    private Long createBy;
	/**
	* 更新者
	*/
    private Long updateBy;
	/**
	* 资源分类
	*/
    private String categoryName;
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
