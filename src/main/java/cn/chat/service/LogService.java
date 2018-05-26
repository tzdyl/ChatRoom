package cn.chat.service;

import cn.chat.entity.Log;

/**
 * 日志Service接口
 */

public interface LogService {

    //插入日志
    boolean insert(Log log);
}
