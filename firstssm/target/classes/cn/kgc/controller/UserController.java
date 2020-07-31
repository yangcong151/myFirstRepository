package cn.kgc.controller;

import cn.kgc.pojo.User;
import cn.kgc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "pageNow", required = false,defaultValue = "1") Integer pageNow,
                        @RequestParam(value = "pageSize", required = false,defaultValue = "10") Integer pageSize,
                        @RequestParam(value = "name", required = false,defaultValue = "") String name,
                        Model model){
        PageInfo<User> userPages = userService.getUserPages(pageNow, pageSize, name);
        model.addAttribute("userPages",userPages);
        model.addAttribute("name",name);
        return "index";
    }

    @RequestMapping("/toadd")
    public String toadd(@RequestParam("pageCount") Integer pageCount, Model model){
        model.addAttribute("pageCount",pageCount);
        return "add";
    }

    @RequestMapping("/add")
    public String add(User user,@RequestParam("pageCount") Integer pageCount){
        //实现添加
        userService.saveUser(user);
        //添加完成后，重定向到查询
        return "redirect:index?pageNow=" + pageCount;
    }
    @RequestMapping("/toupdate")
    public String toupdate(@RequestParam("id") Long id , Model model){
        //根据用户编号查询对象
        User user = userService.getUserById(id);
        //将对象放入到模型中
        model.addAttribute("user",user);
        //转发到修改页面
        return "update";
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:index";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id ,@RequestParam("pageCount") Integer pageCount){
        userService.deleteUser(id);
        return "redirect:index?pageNow="+ pageCount;
    }
}
