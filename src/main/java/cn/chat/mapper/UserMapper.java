package cn.chat.mapper;

import cn.chat.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户的mapper接口
 */

public interface UserMapper {
    //根据用户账号查找用户
    User selectUserByUserid(@Param("userid") String userid);

    //更新用户信息
    boolean update(User existUser);

    //添加(注册)用户
    public void addUser(User user);
}
