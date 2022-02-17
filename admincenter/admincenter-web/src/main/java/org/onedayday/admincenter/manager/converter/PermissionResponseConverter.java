package org.onedayday.admincenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.admincenter.manager.dto.PermissionDTO;
import org.onedayday.admincenter.manager.response.PermissionResponse;
import org.onedayday.framework.common.converter.BaseConverter;

/**   
 * @Title: PermissionResponseConverter
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionResponseConverter  extends BaseConverter<PermissionResponse,PermissionDTO >{


}
