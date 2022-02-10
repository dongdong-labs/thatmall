package org.onedayday.goodscenter.manager.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:  DeptResponse
 * @Description: 部门
 * @author generator
 * @date 2022-02-09 14:59:45
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="DeptResponse对象", description="部门")
public class DeptResponse implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
	/**
	* 上级部门
	*/
    @ApiModelProperty(value = "上级部门")
    private Long pid;
	/**
	* 名称
	*/
    @ApiModelProperty(value = "名称")
    private String deptName;
	/**
	* 机构编码
	*/
    @ApiModelProperty(value = "机构编码")
    private String deptCode;
	/**
	* 纳税人识别号/统一社会信用代码
	*/
    @ApiModelProperty(value = "纳税人识别号/统一社会信用代码")
    private String taxpayerRegisterNumber;
	/**
	* 排序
	*/
    @ApiModelProperty(value = "排序")
    private Integer deptSort;
	/**
	* 状态
	*/
    @ApiModelProperty(value = "状态")
    private Boolean status;
	/**
	* 机构类型
	*/
    @ApiModelProperty(value = "机构类型")
    private String deptType;
	/**
	* 区域编码
	*/
    @ApiModelProperty(value = "区域编码")
    private String areaCode;
	/**
	* 区域名称
	*/
    @ApiModelProperty(value = "区域名称")
    private String areaName;
	/**
	* 机构级别
	*/
    @ApiModelProperty(value = "机构级别")
    private Integer deptLevel;
	/**
	* 省份
	*/
    @ApiModelProperty(value = "省份")
    private String province;
	/**
	* 省份编码
	*/
    @ApiModelProperty(value = "省份编码")
    private String provinceCode;
	/**
	* 城市
	*/
    @ApiModelProperty(value = "城市")
    private String city;
	/**
	* 城市编码
	*/
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
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
    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;
    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
