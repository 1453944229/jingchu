package com.jingchu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingchu.web.domain.Corporation;
import com.jingchu.web.domain.Goods;
import com.jingchu.web.domain.Vehicle;
import com.jingchu.web.service.CorporationService;
import com.jingchu.web.service.GoodsService;
import com.jingchu.web.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author pc
 * creat 2021/11/1-15:37
 */
@Controller
@RequestMapping("/catagory")
public class CatagoryController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CorporationService corporationService;



    @RequestMapping("/{id}")
    public String findCatagory(@PathVariable("id") String id){
        return id;

    }

    @RequestMapping("/cyxx")
    public String goCyxx(@RequestParam(defaultValue = "",value = "province")String province,
                         @RequestParam(defaultValue = "",value ="city")String city,
                         @RequestParam(defaultValue = "",value ="district")String district,
                         @RequestParam(defaultValue = "0.0",value = "carLength")Float carLength,
                         @RequestParam(defaultValue = "",value = "catagory")String catagory,
                         @RequestParam(defaultValue = "0",value ="trainLoad")Integer trainLoad,
                         Model model, HttpSession session, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,10);

        List<Vehicle> vehicleList = vehicleService.search(province, city, district,catagory,carLength,trainLoad);
        PageInfo<Vehicle> pageInfo = new PageInfo<Vehicle>(vehicleList);
        model.addAttribute("pageInfo",pageInfo);
        session.setAttribute ("carLength",carLength);
        session.setAttribute ("district",district);
        session.setAttribute ("province",province);
        session.setAttribute ("trainLoad",trainLoad);
        session.setAttribute ("city",city);
        session.setAttribute ("catagory",catagory);
        return "cyxx";
        }

    @RequestMapping("/hyxx")
    public String goHyxx(@RequestParam(defaultValue = "",value ="province")String province,
                         @RequestParam(defaultValue = "",value ="city")String city,
                         @RequestParam(defaultValue = "",value ="district")String district,
                         @RequestParam(defaultValue = "",value ="province1")String province1,
                         @RequestParam(defaultValue = "",value ="city1")String city1,
                         @RequestParam(defaultValue = "",value ="district1")String district1,
                         @RequestParam(defaultValue = "",value ="catagory")String catagory,
                         @RequestParam(defaultValue = "0.0",value ="weight") Double weight,
                         @RequestParam(defaultValue = "0",value ="volume") Integer volume,
                         Model model,HttpSession session, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,10);
        List<Goods> list = goodsService.search(province, city, district,province1, city1, district1,catagory,weight, volume);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        session.setAttribute ("weight",weight);
        session.setAttribute ("district1",district);
        session.setAttribute ("province1",province);
        session.setAttribute ("city1",city);
        session.setAttribute ("district2",district1);
        session.setAttribute ("province2",province1);
        session.setAttribute ("city2",city1);
        session.setAttribute ("catagory",catagory);
        session.setAttribute ("volume",volume);
        model.addAttribute("pageInfo",pageInfo);
        return "hyxx";
    }

    @RequestMapping("/echarts")
    public String goEcharts(){
        return "redirect:/count/date";

    }
    @RequestMapping("/rzqy")
    public String goRzqyl(Model model,@RequestParam(defaultValue="1",value="pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Corporation> list = corporationService.findAll();
        PageInfo<Corporation>  pageInfo = new PageInfo<Corporation>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "rzqy";

    }

    @RequestMapping("/profile")
    public String goProfile(HttpSession session){
        if(session.getAttribute("user") == null){
//            User user;
//            session.setAttribute()
            return "user/login";
        }
        return "user/personal";

    }




    }




