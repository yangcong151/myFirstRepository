package cn.kgc.service.test;

import cn.kgc.pojo.User;
import cn.kgc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-dao.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void saveTest(){
        for(int i = 1; i <= 50; i++){
            User user = new User();
            user.setName("王宝强" + i);
            user.setPassword("abc" + i);
            user.setAddress("河南");
            user.setBirthday(new Date());
            userService.saveUser(user);
        }
    }
    @Test
    public void testGetUserById(){
        User user = userService.getUserById(1L);
        System.out.println(user);
    }
    @Test
    public void getUserPagesTest(){
        PageInfo<User> userPages = userService.getUserPages(1, 10, "王");
        List<User> list = userPages.getList();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
