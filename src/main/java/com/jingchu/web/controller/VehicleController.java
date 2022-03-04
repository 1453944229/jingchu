package com.jingchu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingchu.web.domain.User;
import com.jingchu.web.domain.Vehicle;
import com.jingchu.web.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pc
 * creat 2021/10/29-17:10
 */

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping({"","/"})
    public String goodsPage(HttpSession session){
        if(session.getAttribute("user") == null){
//            User user;
//            session.setAttribute()
            return "user/login";
        } else {
            User user = (User) session.getAttribute("user");
            Integer status = user.getStatus();
            if(status==1){
                String msg = "货主不能发布货源信息";
                return "redirect:/catagory/cyxx";
            }
            return "user/addvehicle";
        }

    }


    @RequestMapping("del/{id}")
    public String delete(@PathVariable Integer id, HttpSession session, Model model) {
        int i= vehicleService.delete(id);
        if(i==1){
            model.addAttribute("Msg","删除成功");
        }else{
            model.addAttribute("Msg","删除失败");
        }
        return "user/login";
    }

//    @RequestMapping("/findvehicle/{id}")	//t 前台页面查询某一篇文章
//    public String findPassage(@PathVariable Integer id,HttpSession session, Model model){
//        if (session.getAttribute("user") == null) {
//            model.addAttribute("login",false);
//        }else{
//            model.addAttribute("login",true);
//        }
//        vehicle vehicle = vehicleService.findByvehiclename(id);
//
//        model.addAttribute("vehicle",vehicle);
//        session.setAttribute("currentUser",vehicle.getUserId());
//        User user = vehicleService.findUserMore(vehicle.getUserId());
//        user.setRegistAge((int) Duration.between(LocalDateTime.now(),user.getJoinDate()).toDays()/365);
//        model.addAttribute("author",user);
//        return "passage";
//    }
//    跳转到货源信息索引
    @RequestMapping("/userVehicle")
    public String userVehicle(){
          return "user/userVehicle";
     }

    @ResponseBody
    @RequestMapping(value ="/findByUserId", produces = {"application/json;charset=UTF-8"})//t
    public Map<String, Object>  findByUsername(Integer page, Integer limit,HttpSession session,Model model){
        PageHelper.startPage(page,limit);
        User user = (User) session.getAttribute("user");
        String userId =  user.getUserId();
        List<Vehicle> list =  vehicleService.findByUserId(userId);
        PageInfo<Vehicle> pageInfo = new PageInfo<Vehicle>(list);
        model.addAttribute("pageInfo",pageInfo);

        Map<String, Object> map = new HashMap<String, Object>();//将数据装换成JSON格式
        List<Vehicle> hk = new ArrayList<Vehicle>();
        for (Vehicle res : list) {
//               DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//          String date = res.getJoindate().toString();
//            try {
//                res.setJoindate(sf.parse(date));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String localTime = df.format(res.getJoindate());
            LocalDateTime ldt = LocalDateTime.parse(localTime,df);
            String position = (String)res.getProvince()+res.getCity()+res.getDistrict();
            res.setProvince(position);
            res.setJoindate(ldt);
            hk.add(res);
        }
        map.put("code", 0);
        map.put("msg", "操作成功");
        map.put("count", pageInfo.getTotal());
        map.put("data", hk);//最最最关键的代码，layui的table会自动获取并显示该数据集

        return map;

    }



    @RequestMapping("/write")		//点击index中的提交信息后会跳到这里从这里开始
    public String writeBlog(HttpSession session,Model model){
        if(session.getAttribute("user")==null){
            return "user/login";	//用户没有登录，或者登录已经失效
        }
        return "user/vehicle-write";  //货源信息表单提交界面
    }

    @RequestMapping("/add")
    public  String add(Vehicle vehicle, HttpSession session, Model model){
        if(session.getAttribute("user")==null){
            return "user/login";
        }
        //joindate设置
        User user = (User) session.getAttribute("user");
        vehicle.setUsername(user.getUsername());
        vehicle.setUserId(user.getUserId());
        vehicle.setJoindate(LocalDateTime.now());
        int i = vehicleService.addVehicle(vehicle);
        if(i==1){
            model.addAttribute("msg","添加成功");

            return "redirect:/catagory/cyxx";
        }else{
            model.addAttribute("msg","添加失败");
            return "user/login";

        }

    }

}
