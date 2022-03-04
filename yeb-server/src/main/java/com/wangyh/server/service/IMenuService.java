package com.wangyh.server.service;

import com.wangyh.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangyh
 * @since 2022-02-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过用户id获取菜单列表
     *
     * @return
     */
    List<Menu> getMenusByHrId();

    /**
     * 通过角色获取菜单列表
     *
     * @return
     */
    List<Menu> getAllMenusWithRole();

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> getAllMenus();
}
