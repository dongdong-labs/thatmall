package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

/**
 * @Title:  RoleMenuRel
 * @Description: 角色菜单关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role_menu_rel")
public class  RoleMenuRel extends BaseEntity {


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
	
}
