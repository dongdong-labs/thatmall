package org.onedayday.admincenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.admincenter.manager.dto.UserRoleRelDTO;
import org.onedayday.admincenter.manager.request.UserRoleRelRequest;
import org.onedayday.framework.common.converter.BaseConverter;

/**   
 * @Title: UserRoleRelRequestConverter
 * @Description:
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRoleRelRequestConverter  extends BaseConverter<UserRoleRelRequest,UserRoleRelDTO >{


}
