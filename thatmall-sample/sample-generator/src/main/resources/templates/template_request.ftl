package ${tableInfo.getPackageName("Request")};

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
/**
 * @Title:  ${tableInfo.getClassName("Request")}
 * @Description: ${tableInfo.comment}
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */
@Data
@ToString
@ApiModel(value="${tableInfo.getClassName("Request")}对象", description="${tableInfo.comment}")
public class ${tableInfo.getClassName("Request")} implements Serializable {

    private static final long serialVersionUID = -1L;
    private Long id;
<#if columnInfoList??>
	<#list columnInfoList as column>
	/**
	* ${column.fieldComment}
	*/
    @ApiModelProperty(value = "${column.fieldComment}")
    private ${column.cloToJava} ${column.attrName};
	</#list>
</#if>
	
}
