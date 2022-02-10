package ${tableInfo.getPackageName("DTOConverter")};

import org.onedayday.framework.common.converter.BaseConverter;
import ${tableInfo.getPackageName("PO")}.${tableInfo.getClassName("PO")} ;
import ${tableInfo.getPackageName("DTO")}.${tableInfo.getClassName("DTO")} ;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.Date;

/**   
 * @Title: ${tableInfo.getClassName("DTOConverter")}
 * @Description:
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ${tableInfo.getClassName("DTOConverter")}  extends BaseConverter<${tableInfo.getClassName("PO")},${tableInfo.getClassName("DTO")} >{


}
