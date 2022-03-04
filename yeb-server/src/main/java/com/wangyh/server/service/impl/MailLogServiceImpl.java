package com.wangyh.server.service.impl;

import com.wangyh.server.pojo.MailLog;
import com.wangyh.server.mapper.MailLogMapper;
import com.wangyh.server.service.IMailLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyh
 * @since 2022-02-02
 */
@Service
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
