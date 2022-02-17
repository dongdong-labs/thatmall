package org.onedayday.admincenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.admincenter.manager.dto.UserDTO;
import org.onedayday.admincenter.manager.response.UserResponse;
import org.onedayday.framework.common.converter.BaseConverter;

/**   
 * @Title: UserResponseConverter
 * @Description:
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseConverter  extends BaseConverter<UserResponse,UserDTO >{


}
