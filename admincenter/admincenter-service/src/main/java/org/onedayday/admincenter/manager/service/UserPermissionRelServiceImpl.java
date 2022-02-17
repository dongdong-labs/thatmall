package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IUserPermissionRelService;
import org.onedayday.admincenter.manager.converter.UserPermissionRelDTOConverter;
import org.onedayday.admincenter.manager.dto.UserPermissionRelDTO;
import org.onedayday.admincenter.repository.mapper.UserPermissionRelMapper;
import org.onedayday.admincenter.repository.po.UserPermissionRel;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  UserPermissionRelServiceImpl
 * @Description: 用户权限
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

@Service("userPermissionRelService")
@RequiredArgsConstructor
@Slf4j
public class UserPermissionRelServiceImpl  implements IUserPermissionRelService {

    private final UserPermissionRelMapper userPermissionRelMapper;

    private final UserPermissionRelDTOConverter userPermissionRelDTOConverter;

    /**
     * 保存UserPermissionRel
     *
     * @param userPermissionRelDTO
     * @return
     */
    @Override
    public int saveUserPermissionRel(UserPermissionRelDTO userPermissionRelDTO) {
        return  userPermissionRelMapper.insert(userPermissionRelDTOConverter.toSource(userPermissionRelDTO));
    }

    /**
     * 批量删除UserPermissionRel
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteUserPermissionRel(Set<Long> ids) {
        return userPermissionRelMapper.deleteBatchIds(ids);
    }

    /**
     * 更新UserPermissionRel
     *
     * @param userPermissionRelDTO
     * @return
     */
    @Override
    public int updateUserPermissionRel(UserPermissionRelDTO userPermissionRelDTO) {
        return userPermissionRelMapper.updateById(userPermissionRelDTOConverter.toSource(userPermissionRelDTO));
    }

    /**
     * UserPermissionRel分页
     *
     * @param pager<userPermissionRelDTO>
     * @return
     */
    @Override
    public  PagerResult<UserPermissionRelDTO> getPageResult(Pager<UserPermissionRelDTO> pager) {
        QueryWrapper<UserPermissionRel > queryWrapper = new QueryWrapper<>();
        Page<UserPermissionRel> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<UserPermissionRel> iPage = userPermissionRelMapper.selectPage(page,queryWrapper);
        PagerResult<UserPermissionRelDTO> result = new PagerResult<>();
        result.setList(userPermissionRelDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
