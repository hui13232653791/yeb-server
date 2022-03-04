package com.wangyh.server.mapper;

import com.wangyh.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangyh.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangyh
 * @since 2022-02-02
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 添加操作员角色
     *
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
