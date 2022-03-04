package com.wangyh.server.service.impl;

import com.wangyh.server.pojo.Position;
import com.wangyh.server.mapper.PositionMapper;
import com.wangyh.server.service.IPositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

}
