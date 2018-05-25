package cn.chat.service;

import cn.chat.entity.Admin;

import java.util.List;

/**
 * 管理员的service接口
 */

public interface AdminService {

    List<Admin> findAll();
}
