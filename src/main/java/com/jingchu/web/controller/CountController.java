package com.jingchu.web.controller;

import com.jingchu.web.domain.Count;
import com.jingchu.web.domain.Summonth;
import com.jingchu.web.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author pc
 * creat 2021/11/2-17:24
 */
@Controller
@RequestMapping("/count")
public class CountController {

    @Autowired
    private CountService countService;

    @RequestMapping("/date")
    public String findByLocalDate(HttpSession session, Model model){
        List<Count> date = countService.findByLocalDate();
        model.addAttribute("date",date);
        return "echarts";
    }

    @RequestMapping("/sumdate")
    public String findByDate(@RequestParam(defaultValue="2021-11",value="startdate")String stardate, HttpSession session, Model model) throws ParseException {
        model.addAttribute("startdate",stardate);
        DateFormat sf = new SimpleDateFormat("yyyy-MM");
        Date date = sf.parse(stardate);
        System.out.println(date);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println("我是sql"+sqlDate);
        List<Summonth> sumdate = countService.findByDate(sqlDate);
        System.out.println(sumdate);
        //        Date startdate = ft.parse(stardate);
//        System.out.println(startdate);
//            List<Summonth> sumdate = countService.findByDate(startdate);
            model.addAttribute("sumDate",sumdate);
            System.out.println(sumdate);


        return "echarts";
    }


    }





