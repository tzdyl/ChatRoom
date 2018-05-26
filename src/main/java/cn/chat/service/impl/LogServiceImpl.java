package cn.chat.service.impl;

import cn.chat.entity.Log;
import cn.chat.mapper.LogMapper;
import cn.chat.service.LogService;
import cn.chat.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 日志接口的实现类
 */

public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    //插入日志
    @Override
    public boolean insert(Log log) {
        log.setId(StringUtil.getGuid());
        return logMapper.insert(log);
    }
}
