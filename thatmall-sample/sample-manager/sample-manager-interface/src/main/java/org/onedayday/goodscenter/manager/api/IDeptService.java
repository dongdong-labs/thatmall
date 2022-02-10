package org.onedayday.goodscenter.manager.api;

import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.goodscenter.manager.dto.DeptDTO;

import java.util.Set;

/**
 * @Title: IDeptService
 * @Description:
 * @author generator
 * @date 2022-02-09 14:59:45
 * @version 1.0
 */

public interface IDeptService{

    int saveDept(DeptDTO deptDTO);

    int deleteDept(Set<Long> ids);

    int updateDept(DeptDTO deptDTO);

    PagerResult<DeptDTO> getPageResult(Pager<DeptDTO> pager);

}
