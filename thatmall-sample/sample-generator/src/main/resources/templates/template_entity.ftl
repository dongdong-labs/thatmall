package  ${tableInfo.getPackageName("PO")};


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
/**
 * @Title:  ${tableInfo.getClassName("PO")}
 * @Description: ${tableInfo.comment}
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("${tableInfo.tableName}")
public class  ${tableInfo.getClassName("PO")} extends BaseEntity {


<#if columnInfoList??>
	<#list columnInfoList as column>
	/**
	* ${column.fieldComment}
	*/
    private ${column.cloToJava} ${column.attrName};
	</#list>
</#if>
	
}
