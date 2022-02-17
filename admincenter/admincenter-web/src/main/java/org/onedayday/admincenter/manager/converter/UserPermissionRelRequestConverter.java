package org.onedayday.admincenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.admincenter.manager.dto.UserPermissionRelDTO;
import org.onedayday.admincenter.manager.request.UserPermissionRelRequest;
import org.onedayday.framework.common.converter.BaseConverter;

/**   
 * @Title: UserPermissionRelRequestConverter
 * @Description:
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserPermissionRelRequestConverter  extends BaseConverter<UserPermissionRelRequest,UserPermissionRelDTO >{


}
