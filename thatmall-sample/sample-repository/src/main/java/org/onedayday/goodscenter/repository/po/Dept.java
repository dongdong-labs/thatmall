package org.onedayday.goodscenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

/**
 * @Title:  Dept
 * @Description: 部门
 * @author generator
 * @date 2022-02-09 14:59:45
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dept")
public class  Dept extends BaseEntity {


	/**
	* 上级部门
	*/
    private Long pid;
	/**
	* 名称
	*/
    private String deptName;
	/**
	* 机构编码
	*/
    private String deptCode;
	/**
	* 纳税人识别号/统一社会信用代码
	*/
    private String taxpayerRegisterNumber;
	/**
	* 排序
	*/
    private Integer deptSort;
	/**
	* 状态
	*/
    private Boolean status;
	/**
	* 机构类型
	*/
    private String deptType;
	/**
	* 区域编码
	*/
    private String areaCode;
	/**
	* 区域名称
	*/
    private String areaName;
	/**
	* 机构级别
	*/
    private Integer deptLevel;
	/**
	* 省份
	*/
    private String province;
	/**
	* 省份编码
	*/
    private String provinceCode;
	/**
	* 城市
	*/
    private String city;
	/**
	* 城市编码
	*/
    private String cityCode;
	
}
