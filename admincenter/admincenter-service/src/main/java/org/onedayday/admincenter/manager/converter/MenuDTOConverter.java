package org.onedayday.admincenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.admincenter.manager.dto.MenuDTO;
import org.onedayday.admincenter.repository.po.Menu;
import org.onedayday.framework.common.converter.BaseConverter;

/**   
 * @Title: MenuDTOConverter
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:58
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuDTOConverter  extends BaseConverter<Menu,MenuDTO >{


}
