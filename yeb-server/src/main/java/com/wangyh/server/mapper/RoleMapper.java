package com.wangyh.server.mapper;

import com.wangyh.server.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangyh
 * @since 2022-02-02
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id获取权限列表
     *
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
