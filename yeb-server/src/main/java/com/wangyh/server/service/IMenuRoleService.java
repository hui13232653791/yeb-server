package com.wangyh.server.service;

import com.wangyh.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyh.server.pojo.RespBean;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangyh
 * @since 2022-02-02
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     *
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
