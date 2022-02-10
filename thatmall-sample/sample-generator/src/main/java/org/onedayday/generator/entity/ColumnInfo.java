package org.onedayday.generator.entity;

import org.onedayday.generator.utils.ColUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ToString
public class ColumnInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 表格主键
     */
    private Long tableId;
    /**
     * 实体属性名称
     */
    private String attrName;

    /**
     * 数据库字段名称
     */
    private String fieldName;

    /**
     * 字段显示名称
     */
    private String displayName;

    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 长度
     */
    private String fieldLength;

    private String fieldWidth;

    /**
     * 是否为空
     */
    private String fieldNull;
    /**
     * 备注
     */
    private String fieldComment;
    /**
     * 默认值
     */
    private String fieldDefault;


    private Boolean pkFlag;


    public String getCloToJava() {
        return ColUtil.cloToJava(fieldType);
    }


}
