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
 * @Title:  UserRoleRel
 * @Description: 用户角色
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_role_rel")
public class  UserRoleRel extends BaseEntity {


	/**
	* 用户id
	*/
    private Long userId;
	/**
	* 角色Id
	*/
    private Long roleId;
	/**
	* 记录类型 1 用户自己创建时添加 2 上级分配时添加
	*/
    private Integer type;
	/**
	* 创建者
	*/
    private Long createBy;
	/**
	* 更新者
	*/
    private Long updateBy;
	
}
