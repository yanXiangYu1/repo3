package com.web.controller;

import com.web.po.User;
import com.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/addUser")
    public String addUser(String username, String password, Model model){
        System.out.println(username+"--"+password);
        userService.addUser();
        return "test";
    }
    /*
    文件上传
     */
    //name="touxiang"  必须和MultipartFile 参数名一致
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add( MultipartFile touxiang) throws IOException {
        String fileName = touxiang.getOriginalFilename();
        File file = new File("E:/T159/pic/"+fileName);
        touxiang.transferTo(file);


        //如果所有图片都在一个目录下,查找速度会特别慢, 需要分目录保存;
        if(fileName != null && !fileName.equals("")){

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONDAY)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            File file1 = new File("E:/T159/pic/"+year+month+day);
            //判断文件夹是否存在
            if(!file.exists()){
                //不存在创建
                file.mkdirs();
            }
            //拼接图片名字
            int lastIndexOf = fileName.lastIndexOf(".");
            String houZhui = fileName.substring(lastIndexOf);
            String uuidName = UUID.randomUUID().toString() + houZhui;

            File picFile = new File(file,uuidName);
            touxiang.transferTo(picFile);

            //cust.setSavepath(""+year+month+day+"/"+uuidName);// 2019712/uuiddas.jpg
        }
        return "add";
    }

    /*
    json返回数据
     */
    @RequestMapping("/findAll")
    public @ResponseBody List<User> findAll() {
        return userService.findAll();
    }



    /*
    测试
     */
    @RequestMapping("/findUser")
    public String findUser(Model model){
        String username = "闫翔宇";
        User user = userService.findUser(username);
        model.addAttribute("user",user);
        return "test";
    }

    /*登录的时候分配权限*/
   /* public void login(){
        try{
            Subject subject = SecurityUtils.getSubject();

            //Md5Hash hash = new Md5Hash(password, username, 2);
            AuthenticationToken token = new UsernamePasswordToken(username,password);
            subject.login(token);



            User user = (User) subject.getPrincipal();
            //session.setAttribute("user", user);

            if("admin".equals(user.getRolename())){
                return "redirect:/admin/list";
            }else if("teacher".equals(user.getRolename())){
                return "redirect:/teacher/list";
            }else{
                return "redirect:/student/list";
            }
        }catch(Exception e){
            e.printStackTrace();
            return "/login.jsp";
        }
    }*/
}
