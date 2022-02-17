package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IUserRoleRelService;
import org.onedayday.admincenter.manager.converter.UserRoleRelDTOConverter;
import org.onedayday.admincenter.manager.dto.UserRoleRelDTO;
import org.onedayday.admincenter.repository.mapper.UserRoleRelMapper;
import org.onedayday.admincenter.repository.po.UserRoleRel;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  UserRoleRelServiceImpl
 * @Description: 用户角色
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

@Service("userRoleRelService")
@RequiredArgsConstructor
@Slf4j
public class UserRoleRelServiceImpl  implements IUserRoleRelService {

    private final UserRoleRelMapper userRoleRelMapper;

    private final UserRoleRelDTOConverter userRoleRelDTOConverter;

    /**
     * 保存UserRoleRel
     *
     * @param userRoleRelDTO
     * @return
     */
    @Override
    public int saveUserRoleRel(UserRoleRelDTO userRoleRelDTO) {
        return  userRoleRelMapper.insert(userRoleRelDTOConverter.toSource(userRoleRelDTO));
    }

    /**
     * 批量删除UserRoleRel
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteUserRoleRel(Set<Long> ids) {
        return userRoleRelMapper.deleteBatchIds(ids);
    }

    /**
     * 更新UserRoleRel
     *
     * @param userRoleRelDTO
     * @return
     */
    @Override
    public int updateUserRoleRel(UserRoleRelDTO userRoleRelDTO) {
        return userRoleRelMapper.updateById(userRoleRelDTOConverter.toSource(userRoleRelDTO));
    }

    /**
     * UserRoleRel分页
     *
     * @param pager<userRoleRelDTO>
     * @return
     */
    @Override
    public  PagerResult<UserRoleRelDTO> getPageResult(Pager<UserRoleRelDTO> pager) {
        QueryWrapper<UserRoleRel > queryWrapper = new QueryWrapper<>();
        Page<UserRoleRel> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<UserRoleRel> iPage = userRoleRelMapper.selectPage(page,queryWrapper);
        PagerResult<UserRoleRelDTO> result = new PagerResult<>();
        result.setList(userRoleRelDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
