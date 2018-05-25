package cn.chat.service.impl;

/**
 * 管理员service接口的实现类
 */

import cn.chat.entity.Admin;
import cn.chat.mapper.AdminMapper;
import cn.chat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    //注入adminMapper
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }
}
