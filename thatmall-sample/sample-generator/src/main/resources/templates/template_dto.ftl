package ${tableInfo.getPackageName("DTO")};

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
/**
 * @Title:  ${tableInfo.getClassName("DTO")}
 * @Description: ${tableInfo.comment}
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */
@Data
@ToString
public class ${tableInfo.getClassName("DTO")} implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

<#if columnInfoList??>
	<#list columnInfoList as column>
	/**
	* ${column.fieldComment}
	*/
    private ${column.cloToJava} ${column.attrName};
	</#list>
</#if>
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
    private Date modifyTime;
    /**
    * 创建时间
    */
    private Date createTime;
}
