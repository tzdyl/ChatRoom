package cn.chat.mapper;

import cn.chat.entity.Admin;

import java.util.List;

/**
 * 管理员的mapper接口
 */

public interface AdminMapper {

    List<Admin> findAll();
}
