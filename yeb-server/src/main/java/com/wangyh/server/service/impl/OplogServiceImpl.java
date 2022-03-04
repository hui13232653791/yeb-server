package com.wangyh.server.service.impl;

import com.wangyh.server.pojo.Oplog;
import com.wangyh.server.mapper.OplogMapper;
import com.wangyh.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
