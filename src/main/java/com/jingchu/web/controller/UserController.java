package com.jingchu.web.controller;

import com.jingchu.web.domain.User;
import com.jingchu.web.service.UserService;
import com.jingchu.web.utils.MD5Utils;
import com.jingchu.web.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author pc
 * creat 2021/10/27-20:16
 */
@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"","/"})
    public String loginPage(HttpSession session){
        if(session.getAttribute("user") == null){
//            User user;
//            session.setAttribute()
            return "user/login";
        }
        return "redirect:/catagory/cyxx";
    }

//    图形验证码
      @ResponseBody
      @GetMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        String code = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(code);

        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);
        System.out.println(code);
        session.setAttribute("code2",code);
    }

//登录
    @RequestMapping("/login")//t
        //获取页面表单中name为userId和password的输入框值
    String login(@RequestParam("userId") String userId, @RequestParam("password") String password,
                 @RequestParam(defaultValue = "0",value="status")Integer status, Model model, HttpSession session){
        password = MD5Utils.code(password);
        User user = userService.login(userId,password,status);
//        System.out.println(user);
        if (user==null){
            System.out.println("error");
            model.addAttribute("LoginMsg","账号信息输入错误");
            return "user/login";
        }
        session.setAttribute("user",user);
        model.addAttribute("user",user);
        return "user/personal";
    }

//    用户注销
    @RequestMapping("/logout")

        String logout(HttpSession session){
        User user = (User)session.getAttribute("user");
        user.setLastTime(LocalDateTime.now());
        userService.updateUserTime(user.getLastTime(),user.getUserId());
        session.removeAttribute("user");
        return "redirect:/catagory/cyxx";
        //用户界面：及登陆页面
    }

//用户注册页索引
    @RequestMapping("/reg")
    String toreg( Model model){
        model.addAttribute("regMsg", "正确");
        return "user/doreg";
    }
//    用户注册
    @RequestMapping("/doreg")
    public String register(User user, Model model) {
        user.setJoinDate(LocalDateTime.now());
        user.setPassword(MD5Utils.code(user.getPassword()));
//        注册逻辑函数
        try {
            User userExist = userService.findByUserId(user.getUserId());
            if (userExist != null) {
                model.addAttribute("regMsg", "账户已经存在");
                return "user/doreg";
            } else {
                userService.register(user);
                model.addAttribute("regMsg", "注册成功");
                return "user/login";

            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
//    跳转到个人信息界面索引
    @RequestMapping("/personal")

    String toPersonal(HttpSession session){
        if(session.getAttribute("user") == null){

            return "user/login";
        }
        return "user/personal";
    }
//    跳转到密码更改界面索引
    @RequestMapping("/changePass")

    String changePass(){


        return "user/changePass";
    }

//    用户密码更改
    @PostMapping("change")//t
    String change(@RequestParam String password,@RequestParam String newPass,
                  Model model,HttpSession session){
        User user=(User)session.getAttribute("user");
        System.out.println(user);
       int i = userService.findPassword(user.getUserId(), password);
        if(i!=1){
            model.addAttribute("errorMessage","原先密码输入不正确");
            return "user/changePass";
        }else{
            i=userService.changePassage(user.getUserId(),newPass);
            if(i==1){
                model.addAttribute("errorMessage","修改成功");
                return "user/changePass";
            }
        }
        model.addAttribute("errorMessage","修改失败");
        return "user/changePass";
    }
// 用户信息修改
    @RequestMapping("/update")
    String updateUser( @RequestParam String username, @RequestParam String telnum, HttpSession session ) {

        User user=(User)session.getAttribute("user");
        String userId = user.getUserId();
        int i = userService.updateUser(username,telnum,userId);
        user.setUsername(username);
        user.setTelnum(telnum);
        session.setAttribute("user",user);

        return "redirect:/personal";
    }
}

