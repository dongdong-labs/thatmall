package org.onedayday.goodscenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.onedayday.goodscenter.manager.api.IDeptService;
import org.onedayday.goodscenter.manager.converter.DeptDTOConverter;
import org.onedayday.goodscenter.manager.dto.DeptDTO;
import org.onedayday.goodscenter.repository.mapper.DeptMapper;
import org.onedayday.goodscenter.repository.po.Dept;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  DeptServiceImpl
 * @Description: 部门
 * @author generator
 * @date 2022-02-10 10:16:28
 * @version 1.0
 */

@Service("deptService")
@RequiredArgsConstructor
@Slf4j
public class DeptServiceImpl implements IDeptService {

    private final DeptMapper deptMapper;

    private final DeptDTOConverter deptDTOConverter;

    /**
     * 保存Dept
     *
     * @param deptDTO
     * @return
     */
    @Override
    public int saveDept(DeptDTO deptDTO) {
        return  deptMapper.insert(deptDTOConverter.toSource(deptDTO));
    }

    /**
     * 批量删除Dept
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteDept(Set<Long> ids) {
        return deptMapper.deleteBatchIds(ids);
    }

    /**
     * 更新Dept
     *
     * @param deptDTO
     * @return
     */
    @Override
    public int updateDept(DeptDTO deptDTO) {
        return deptMapper.updateById(deptDTOConverter.toSource(deptDTO));
    }

    /**
     * Dept分页
     *
     * @param pager<deptDTO>
     * @return
     */
    @Override
    public  PagerResult<DeptDTO> getPageResult(Pager<DeptDTO> pager) {
        QueryWrapper<Dept > queryWrapper = new QueryWrapper<>();
        Page<Dept> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<Dept> iPage = deptMapper.selectPage(page,queryWrapper);
        PagerResult<DeptDTO> result = new PagerResult<>();
        result.setList(deptDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
