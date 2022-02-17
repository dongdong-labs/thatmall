package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

/**
 * @Title:  Permission
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_permission")
public class  Permission extends BaseEntity {


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
	
}
