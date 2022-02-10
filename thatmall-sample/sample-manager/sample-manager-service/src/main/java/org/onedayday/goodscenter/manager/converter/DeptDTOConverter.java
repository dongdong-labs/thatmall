package org.onedayday.goodscenter.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.onedayday.framework.common.converter.BaseConverter;
import org.onedayday.goodscenter.manager.dto.DeptDTO;
import org.onedayday.goodscenter.repository.po.Dept;

/**
 * @author generator
 * @version 1.0
 * @Title: DeptDTOConverter
 * @Description:
 * @date 2022-02-09 14:59:45
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptDTOConverter extends BaseConverter<Dept, DeptDTO> {


}
