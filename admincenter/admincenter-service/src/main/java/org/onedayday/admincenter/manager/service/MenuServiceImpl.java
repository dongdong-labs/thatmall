package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IMenuService;
import org.onedayday.admincenter.manager.converter.MenuDTOConverter;
import org.onedayday.admincenter.manager.dto.MenuDTO;
import org.onedayday.admincenter.repository.mapper.MenuMapper;
import org.onedayday.admincenter.repository.po.Menu;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  MenuServiceImpl
 * @Description: 系统菜单
 * @author generator
 * @date 2022-02-14 14:46:58
 * @version 1.0
 */

@Service("menuService")
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl  implements IMenuService {

    private final MenuMapper menuMapper;

    private final MenuDTOConverter menuDTOConverter;

    /**
     * 保存Menu
     *
     * @param menuDTO
     * @return
     */
    @Override
    public int saveMenu(MenuDTO menuDTO) {
        return  menuMapper.insert(menuDTOConverter.toSource(menuDTO));
    }

    /**
     * 批量删除Menu
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteMenu(Set<Long> ids) {
        return menuMapper.deleteBatchIds(ids);
    }

    /**
     * 更新Menu
     *
     * @param menuDTO
     * @return
     */
    @Override
    public int updateMenu(MenuDTO menuDTO) {
        return menuMapper.updateById(menuDTOConverter.toSource(menuDTO));
    }

    /**
     * Menu分页
     *
     * @param pager<menuDTO>
     * @return
     */
    @Override
    public  PagerResult<MenuDTO> getPageResult(Pager<MenuDTO> pager) {
        QueryWrapper<Menu > queryWrapper = new QueryWrapper<>();
        Page<Menu> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<Menu> iPage = menuMapper.selectPage(page,queryWrapper);
        PagerResult<MenuDTO> result = new PagerResult<>();
        result.setList(menuDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
