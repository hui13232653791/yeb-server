package com.wangyh.server.service.impl;

import com.wangyh.server.pojo.Admin;
import com.wangyh.server.pojo.Menu;
import com.wangyh.server.mapper.MenuMapper;
import com.wangyh.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyh.server.utils.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangyh
 * @since 2022-02-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过用户id获取菜单列表
     *
     * @return
     */
    @Override
    public List<Menu> getMenusByHrId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //查询缓存中是否有数据
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        if (CollectionUtils.isEmpty(menus)) {
            //如果没数据，数据库中查询，并设置到缓存中
            menus = menuMapper.getMenusByAdminId(adminId);
            valueOperations.set("menu_" + adminId, menus);
        }
        return menus;
    }

    /**
     * 通过角色获取菜单列表
     *
     * @return
     */
    @Override
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    /**
     * 查询所有菜单
     *
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
