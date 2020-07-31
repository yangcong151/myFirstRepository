package cn.kgc.service;

import cn.kgc.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    /*
     * @Description 添加用户
     * @Param [user]
     * @return void
     * @Author yangc
     * @Date 2020/4/20 10:33
     **/
    void saveUser(User user);
    /*
     * @Description 根据主键删除用户
     * @Param [id]
     * @return void
     * @Author yangc
     * @Date 2020/4/20 11:53
     **/
    void deleteUser(Long id);
    /*
     * @Description 修改用户
     * @Param [user]
     * @return void
     * @Author yangc
     * @Date 2020/4/20 11:55
     **/
    void updateUser(User user);
    /*
     * @Description 通过主键查询用户
     * @Param [id]
     * @return cn.kgc.pojo.User
     * @Author yangc
     * @Date 2020/4/20 11:56
     **/
    User getUserById(Long id);
    /*
     * @Description 分页查询 可通过姓名做模糊查询
     * @Param [pageNow, pageSize, name] 当前页码    每页展示的信息条数   用户给的用户名
     * @return com.github.pagehelper.PageInfo<cn.kgc.pojo.User>
     * @Author yangc
     * @Date 2020/4/20 11:59
     **/
    PageInfo<User> getUserPages(Integer pageNow,Integer pageSize,String name);
}
