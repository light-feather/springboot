package com.charis.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

//@RestController
@Controller
public class HelloController {
    //对应的地址为localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
        //测试热部署
        m.addAttribute("test","testing");
        m.addAttribute("test1","testing");
        m.addAttribute("now",
                DateFormat.getDateTimeInstance().format(new Date()));
        //抛出异常，让Handler类去接受
        if(true){
            throw new Exception("some exception");
        }
        return "hello";
    }
}
