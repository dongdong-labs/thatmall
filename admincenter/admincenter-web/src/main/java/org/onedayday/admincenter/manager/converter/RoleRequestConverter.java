package org.onedayday.admincenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.admincenter.manager.dto.RoleDTO;
import org.onedayday.admincenter.manager.request.RoleRequest;
import org.onedayday.framework.common.converter.BaseConverter;

/**   
 * @Title: RoleRequestConverter
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleRequestConverter  extends BaseConverter<RoleRequest,RoleDTO >{


}
