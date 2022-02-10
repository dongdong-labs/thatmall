package org.onedayday.generator.entity;


import org.onedayday.generator.utils.FileNameUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.List;


/**
 * 类名:
 * 创建人: wdd
 * 创建时间: 2017/12/4
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class TableInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 表格名称
     */
    private String title;
    /**
     * 表格名称
     */
    private String tableName;
    /**
     * 类名称
     */
    private String className;
    /**
     * 数据表创建类型
     */
    private Integer createType;
    /**
     * 备注
     */
    private String comment;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 创建用户
     */
    private String author;

    /**
     * 列信息
     */
    private List<ColumnInfo> columns;

    private String createDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");


    public String getClassName(String type) {
        if ("Service".equals(type)) {
            return "I" + FileNameUtil.firstCharacterToUpper(this.className) + type;
        }
        if ("PO".equals(type)) {
            return this.className;
        }
        return this.className + type;
    }


    public String getPackageName(String type) {
        StringBuilder result = new StringBuilder("org.onedayday.").append(moduleName);
        if ("DTO".equals(type)) {
            return result.append(".manager.dto").toString();
        }
        if ("Controller".equals(type)) {
            return result.append(".manager.controller").toString();
        }
        if ("Request".equals(type)) {
            return result.append(".manager.request").toString();
        }
        if ("Response".equals(type)) {
            return result.append(".manager.response").toString();
        }
        if ("Service".equals(type)) {
            return result.append(".manager.api").toString();
        }
        if ("ServiceImpl".equals(type)) {
            return result.append(".manager.service").toString();
        }
        if ("PO".equals(type)) {
            return result.append(".repository.po").toString();
        }
        if ("Mapper".equals(type)) {
            return result.append(".repository.mapper").toString();
        }
        if (type.endsWith("Converter")) {
            return result.append(".manager.converter").toString();
        }
        if ("ExportService".equals(type)) {
            return result.append(".manager.export.api").toString();
        }
        if ("ExportServiceImpl".equals(type)) {
            return result.append(".manager.export.service").toString();
        }
        return result.append("error").toString();
    }

    public String getFileName(String type) {
        return (getPackageName(type) + "." + getClassName(type)).replace(".", "/") + ".java";
    }

}
