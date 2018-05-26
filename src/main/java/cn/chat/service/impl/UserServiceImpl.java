package cn.chat.service.impl;

import cn.chat.entity.User;
import cn.chat.mapper.UserMapper;
import cn.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户接口的实现类
 */

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //根据账号查找用户
    @Override
    public User selectUserByUserid(String userid) {
        return userMapper.selectUserByUserid(userid);
    }

    //更新用户信息
    @Override
    public boolean update(User existUser) {
        return userMapper.update(existUser);
    }
}
