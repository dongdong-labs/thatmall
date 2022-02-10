package ${tableInfo.getPackageName("RequestConverter")};

import org.onedayday.framework.common.converter.BaseConverter;
import ${tableInfo.getPackageName("Request")}.${tableInfo.getClassName("Request")} ;
import ${tableInfo.getPackageName("DTO")}.${tableInfo.getClassName("DTO")} ;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**   
 * @Title: ${tableInfo.getClassName("RequestConverter")}
 * @Description:
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ${tableInfo.getClassName("RequestConverter")}  extends BaseConverter<${tableInfo.getClassName("Request")},${tableInfo.getClassName("DTO")} >{


}
