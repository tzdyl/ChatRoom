package cn.chat.service;

import cn.chat.entity.User;

/**
 * 用户的service接口
 */

public interface UserService {
    //根据账号查找用户
    User selectUserByUserid(String userid);

    //更新用户信息
    boolean update(User existUser);
}
