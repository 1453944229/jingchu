package com.jingchu.web.controller;

import com.jingchu.web.domain.Goods;
import com.jingchu.web.domain.User;
import com.jingchu.web.service.GoodsService;
import com.jingchu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author pc
 * creat 2021/10/29-16:15
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @RequestMapping({"","/"})
    public String goodsPage(HttpSession session,Model model){
        if(session.getAttribute("user") == null){
//            User user;

//            session.setAttribute()
            return "user/login";
        }else {
            User user = (User) session.getAttribute("user");
            Integer status = user.getStatus();
            if(status==2){
              String msg = "车主不能发布货源信息";
                return "redirect:/catagory/hyxx";
            }

            return "user/addgoods";
        }


    }


    @RequestMapping("del/{id}")
    public String delete(@PathVariable Integer id, HttpSession session, Model model) {
        int i= goodsService.delete(id);
        if(i==1){
            model.addAttribute("Msg","删除成功");
        }else{
            model.addAttribute("Msg","删除失败");
        }
        return "user/login";
    }

//    @RequestMapping("/findGoods/{id}")	//t 前台页面查询某一篇文章
//    public String findPassage(@PathVariable Integer id,HttpSession session, Model model){
//        if (session.getAttribute("user") == null) {
//            model.addAttribute("login",false);
//        }else{
//            model.addAttribute("login",true);
//        }
//        Goods goods = GoodsService.findByGoodsname(id);
//
//        model.addAttribute("Goods",goods);
//        session.setAttribute("currentUser",goods.getUserId());
//        User user = goodsService.findUserMore(goods.getUserId());
//        user.setRegistAge((int) Duration.between(LocalDateTime.now(),user.getJoinDate()).toDays()/365);
//        model.addAttribute("author",user);
//        return "passage";
//    }

    @RequestMapping("/findByUsername")//t
    public String findByUsername(HttpSession session,Model model){
        if(session.getAttribute("user")==null){
            return "user/login";	//用户没有登录，或者登录已经失效
        }
        model.addAttribute("goodsList",
                goodsService.findByUsername(((User)session.getAttribute("user")).getUsername()));
        return "user/login";
    }



    @RequestMapping("/write")		//点击index中的提交信息后会跳到这里从这里开始
    public String writeBlog(HttpSession session,Model model){
        if(session.getAttribute("user")==null){
            return "user/login";	//用户没有登录，或者登录已经失效
        }
        return "user/goods-write";  //货源信息表单提交界面
    }


    @RequestMapping("/add")
    public  String add(Goods goods, HttpSession session, Model model){
        if(session.getAttribute("user")==null){
            return "user/login";
        }
        //货物信息设置
        User user = (User) session.getAttribute("user");
        goods.setUsername(user.getUsername());
        goods.setUserId(user.getUserId());
        goods.setJoindate(LocalDateTime.now());
//        String id = UUID.randomUUID().toString();
//        goods.setId(Integer.parseInt(id));
        int i = goodsService.addGoods(goods);
        if(i==1){
            model.addAttribute("msg","添加成功");
            /*List<Goods> goodsList = goodsService.findAll();
            model.addAttribute("goodsList",goodsList);*/
            return "redirect:/catagory/hyxx";
        }else{
            model.addAttribute("msg","添加失败");
            return "user/login";

        }

    }

}
