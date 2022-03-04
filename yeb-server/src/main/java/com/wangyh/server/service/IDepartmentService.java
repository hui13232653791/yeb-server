package com.wangyh.server.service;

import com.wangyh.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyh.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangyh
 * @since 2022-02-02
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     *
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     *
     * @param dep
     * @return
     */
    RespBean addDep(Department dep);

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    RespBean deleteDep(Integer id);
}
