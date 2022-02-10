package org.onedayday.goodscenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.framework.common.converter.BaseConverter;
import org.onedayday.goodscenter.manager.dto.DeptDTO;
import org.onedayday.goodscenter.manager.request.DeptRequest;

/**   
 * @Title: DeptRequestConverter
 * @Description:
 * @author generator
 * @date 2022-02-09 14:59:45
 * @version 1.0
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptRequestConverter  extends BaseConverter<DeptRequest ,DeptDTO >{


}
