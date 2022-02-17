package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

import java.sql.Timestamp;
/**
 * @Title:  UserPermissionRel
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_permission_rel")
public class  UserPermissionRel extends BaseEntity {


	/**
	* 用户id
	*/
    private Long userId;
	/**
	* 权限id
	*/
    private Long permissionId;
	/**
	* 创建者
	*/
    private Long createBy;
	/**
	* 更新者
	*/
    private Long updateBy;
	
}
