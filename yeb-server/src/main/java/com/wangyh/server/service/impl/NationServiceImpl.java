package com.wangyh.server.service.impl;

import com.wangyh.server.pojo.Nation;
import com.wangyh.server.mapper.NationMapper;
import com.wangyh.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
