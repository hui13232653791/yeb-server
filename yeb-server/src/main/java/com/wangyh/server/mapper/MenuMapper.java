package com.wangyh.server.mapper;

import com.wangyh.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangyh
 * @since 2022-02-03
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户id获取菜单列表
     *
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);

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
