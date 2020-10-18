package com.web.controller;

import com.web.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BankController {
    /*
    测试事务
     */
    @Autowired
    private BankService bankService;


    @RequestMapping("/addMoney")
    public void addMoney(HttpServletResponse response) throws IOException {
        System.out.println("方法执行了");
        bankService.addMoney();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("转账成功!");
		System.out.println("哈哈哈哈哈");
    }
}
