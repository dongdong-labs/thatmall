package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

/**
 * @Title:  Resource
 * @Description: 后台资源
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_resource")
public class  Resource extends BaseEntity {


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
	
}
