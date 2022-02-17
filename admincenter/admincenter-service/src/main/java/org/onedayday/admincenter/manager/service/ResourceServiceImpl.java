package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IResourceService;
import org.onedayday.admincenter.manager.converter.ResourceDTOConverter;
import org.onedayday.admincenter.manager.dto.ResourceDTO;
import org.onedayday.admincenter.repository.mapper.ResourceMapper;
import org.onedayday.admincenter.repository.po.Resource;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  ResourceServiceImpl
 * @Description: 后台资源
 * @author generator
 * @date 2022-02-14 14:46:59
 * @version 1.0
 */

@Service("resourceService")
@RequiredArgsConstructor
@Slf4j
public class ResourceServiceImpl  implements IResourceService {

    private final ResourceMapper resourceMapper;

    private final ResourceDTOConverter resourceDTOConverter;

    /**
     * 保存Resource
     *
     * @param resourceDTO
     * @return
     */
    @Override
    public int saveResource(ResourceDTO resourceDTO) {
        return  resourceMapper.insert(resourceDTOConverter.toSource(resourceDTO));
    }

    /**
     * 批量删除Resource
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteResource(Set<Long> ids) {
        return resourceMapper.deleteBatchIds(ids);
    }

    /**
     * 更新Resource
     *
     * @param resourceDTO
     * @return
     */
    @Override
    public int updateResource(ResourceDTO resourceDTO) {
        return resourceMapper.updateById(resourceDTOConverter.toSource(resourceDTO));
    }

    /**
     * Resource分页
     *
     * @param pager<resourceDTO>
     * @return
     */
    @Override
    public  PagerResult<ResourceDTO> getPageResult(Pager<ResourceDTO> pager) {
        QueryWrapper<Resource > queryWrapper = new QueryWrapper<>();
        Page<Resource> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<Resource> iPage = resourceMapper.selectPage(page,queryWrapper);
        PagerResult<ResourceDTO> result = new PagerResult<>();
        result.setList(resourceDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
