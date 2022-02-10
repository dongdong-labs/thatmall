package ${tableInfo.getPackageName("ResponseConverter")};

import org.onedayday.framework.common.converter.BaseConverter;
import ${tableInfo.getPackageName("Response")}.${tableInfo.getClassName("Response")} ;
import ${tableInfo.getPackageName("DTO")}.${tableInfo.getClassName("DTO")} ;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.Date;

/**   
 * @Title: ${tableInfo.getClassName("ResponseConverter")}
 * @Description:
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ${tableInfo.getClassName("ResponseConverter")}  extends BaseConverter<${tableInfo.getClassName("Response")},${tableInfo.getClassName("DTO")} >{


}
