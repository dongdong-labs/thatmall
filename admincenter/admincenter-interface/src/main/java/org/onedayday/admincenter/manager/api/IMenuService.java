package org.onedayday.admincenter.manager.api;

import org.onedayday.admincenter.manager.dto.MenuDTO;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import java.util.Set;

/**
 * @Title: IMenuService
 * @Description:
 * @author generator
 * @date 2022-02-14 14:46:58
 * @version 1.0
 */

public interface IMenuService{

    /**
     * 保存Menu
     *
     * @param menuDTO
     * @return
     */
    int saveMenu(MenuDTO menuDTO);

    /**
     * 批量删除Menu
     *
     * @param ids
     * @return
     */
    int deleteMenu(Set<Long> ids);

    /**
     * 更新Menu
     *
     * @param menuDTO
     * @return
     */
    int updateMenu(MenuDTO menuDTO);

    /**
     * Menu分页
     *
     * @param pager<menuDTO>
     * @return
     */
    PagerResult<MenuDTO> getPageResult(Pager<MenuDTO> pager);

}
