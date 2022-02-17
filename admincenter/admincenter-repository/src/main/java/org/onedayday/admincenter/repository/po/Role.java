package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

/**
 * @Title:  Role
 * @Description: 角色表
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role")
public class  Role extends BaseEntity {


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
	
}
