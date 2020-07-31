package cn.kgc.service.impl;

import cn.kgc.mapper.UserMapper;
import cn.kgc.pojo.User;
import cn.kgc.pojo.UserExample;
import cn.kgc.pojo.UserExample.Criteria;
import cn.kgc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<User> getUserPages(Integer pageNow, Integer pageSize, String name) {
        //开始分页
        PageHelper.startPage(pageNow,pageSize);
        //2.执行查询
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        if (name != null &&  !"".equals(name)){
            criteria.andNameLike("%"+name+"%");
        }
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
