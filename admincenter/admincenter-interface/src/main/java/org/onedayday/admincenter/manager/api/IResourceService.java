package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.ResourceDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IResourceService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

public interface IResourceService{

    /**
     * 保存Resource
     *
     * @param resourceDTO
     * @return
     */
    int saveResource(ResourceDTO resourceDTO);

    /**
     * 批量删除Resource
     *
     * @param ids
     * @return
     */
    int deleteResource(Set<Long> ids);

    /**
     * 更新Resource
     *
     * @param resourceDTO
     * @return
     */
    int updateResource(ResourceDTO resourceDTO);

    /**
     * Resource分页
     *
     * @param pager<resourceDTO>
     * @return
     */
    PagerResult<ResourceDTO> getPageResult(Pager<ResourceDTO> pager);

}
