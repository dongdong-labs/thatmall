package org.onedayday.goodscenter.manager.api;

import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.goodscenter.manager.dto.DeptDTO;

import java.util.Set;

/**
 * @Title: IDeptService
 * @Description:
 * @author generator
 * @date 2022-02-10 10:16:28
 * @version 1.0
 */

public interface IDeptService {

    /**
     * 保存Dept
     *
     * @param deptDTO
     * @return
     */
    int saveDept(DeptDTO deptDTO);

    /**
     * 批量删除Dept
     *
     * @param ids
     * @return
     */
    int deleteDept(Set<Long> ids);

    /**
     * 更新Dept
     *
     * @param deptDTO
     * @return
     */
    int updateDept(DeptDTO deptDTO);

    /**
     * Dept分页
     *
     * @param pager<deptDTO>
     * @return
     */
    PagerResult<DeptDTO> getPageResult(Pager<DeptDTO> pager);

}
