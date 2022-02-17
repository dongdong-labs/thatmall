package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

/**
 * @Title:  RolePermissionRel
 * @Description: 角色资源关系
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role_permission_rel")
public class  RolePermissionRel extends BaseEntity {


	/**
	* 菜单ID
	*/
    private Long permissionId;
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
