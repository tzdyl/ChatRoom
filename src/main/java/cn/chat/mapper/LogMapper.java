package cn.chat.mapper;

import cn.chat.entity.Log;

/**
 * 日志的mapper接口
 */

public interface LogMapper {

    //插入日志
    boolean insert(Log log);
}
