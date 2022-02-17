package org.onedayday.admincenter.manager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.onedayday.admincenter.manager.api.IUserService;
import org.onedayday.admincenter.manager.converter.UserDTOConverter;
import org.onedayday.admincenter.manager.dto.UserDTO;
import org.onedayday.admincenter.repository.mapper.UserMapper;
import org.onedayday.admincenter.repository.po.User;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  UserServiceImpl
 * @Description: 系统用户
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */

@Service("userService")
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl  implements IUserService {

    private final UserMapper userMapper;

    private final UserDTOConverter userDTOConverter;

    /**
     * 保存User
     *
     * @param userDTO
     * @return
     */
    @Override
    public int saveUser(UserDTO userDTO) {
        return  userMapper.insert(userDTOConverter.toSource(userDTO));
    }

    /**
     * 批量删除User
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteUser(Set<Long> ids) {
        return userMapper.deleteBatchIds(ids);
    }

    /**
     * 更新User
     *
     * @param userDTO
     * @return
     */
    @Override
    public int updateUser(UserDTO userDTO) {
        return userMapper.updateById(userDTOConverter.toSource(userDTO));
    }

    /**
     * User分页
     *
     * @param pager<userDTO>
     * @return
     */
    @Override
    public  PagerResult<UserDTO> getPageResult(Pager<UserDTO> pager) {
        QueryWrapper<User > queryWrapper = new QueryWrapper<>();
        Page<User> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<User> iPage = userMapper.selectPage(page,queryWrapper);
        PagerResult<UserDTO> result = new PagerResult<>();
        result.setList(userDTOConverter.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
