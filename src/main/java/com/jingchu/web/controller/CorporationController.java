package com.jingchu.web.controller;

import com.jingchu.web.domain.Corporation;
import com.jingchu.web.service.CorporationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author pc
 * creat 2021/11/12-20:31
 */
@Controller
@RequestMapping("/corporation")
public class CorporationController {
    @Autowired
    private CorporationService corporationService;
//跳转商家登记界面
    @RequestMapping("/add")
    public String goAddCompany(){
        return "addcompany";

    }



    @SneakyThrows
    @RequestMapping("/doAdd")
    public String addCorporation(String corpName, String corpPosition, Integer corEmployeeNum, String startDate, String endDate,
                                 @RequestParam(value = "file") MultipartFile file, Model model){
        System.out.println(file);
        DateFormat sf = new SimpleDateFormat("yyyy-MM");
        Date startDate1 = sf.parse(startDate);
        Date endDate1 = sf.parse(endDate);
        Corporation corporation = new Corporation();
        corporation.setCorpName(corpName);
        corporation.setCorpPosition(corpPosition);
        corporation.setCorEmployeeNum(corEmployeeNum);
        corporation.setStartDate(startDate1);
        corporation.setEndDate(endDate1);

            //        图片url获取

            //         时间格式化
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");
            //1.后半段目录：  2020/03/15
            String directory = simpleDateFormat.format(new Date());
            /**
             *  2.文件保存目录  E:/images/2020/03/15/
             *  如果目录不存在，则创建
             */
            String fileSavePath = "/static/images/uploads/";
            File dir = new File(fileSavePath + directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }
//            log.info("图片上传，保存位置：" + fileSavePath + directory);
            //3.给文件重新设置一个名字

            String fileName = file.getOriginalFilename();
            String suffix  = fileName.substring(fileName.lastIndexOf("."));
            //后缀
            String newFileName= UUID.randomUUID().toString().replaceAll("-", "")+suffix;
            //4.创建这个新文件
            File newFile = new File(fileSavePath + directory + newFileName);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String url = request.getScheme() + "://" +
//                request.getServerName() + ":" + request.getServerPort() + "/images/"
//                + directory + newFileName;
        String imageUrl =  "/uploads/"+ directory + newFileName;
        model.addAttribute("imageUrl", imageUrl);


        corporation.setCorLicence(imageUrl);
        corporationService.addCorporation(corporation);
        return "redirect:/catagory/rzqy";

    }
    @RequestMapping("/images")
    public String findimg(HttpServletRequest request, Model model){
        String path =request.getParameter("path");
        model.addAttribute("path",path);
        return "iamgeShow";
    }
}
