package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

/**
 * @Title:  Menu
 * @Description: 系统菜单
 * @author generator
 * @date 2022-02-14 14:46:58
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_menu")
public class  Menu extends BaseEntity {


	/**
	* 上级菜单ID
	*/
    private Long pid;
	/**
	* 菜单类型
	*/
    private Integer type;
	/**
	* 菜单标题
	*/
    private String title;
	/**
	* 前端名称
	*/
    private String name;
	/**
	* 排序
	*/
    private Integer sort;
	/**
	* 菜单级数
	*/
    private Integer level;
	/**
	* 图标
	*/
    private String icon;
	/**
	* 缓存
	*/
    private Boolean cache;
	/**
	* 隐藏
	*/
    private Boolean hidden;
	
}
