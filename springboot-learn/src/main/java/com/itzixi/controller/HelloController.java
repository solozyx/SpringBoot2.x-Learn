package com.itzixi.controller;

import com.itzixi.config.SpringBootConfig;
import com.itzixi.pojo.MyBean;
import com.itzixi.pojo.Stu;
import com.itzixi.pojo.UserConfig;
import com.itzixi.utils.AsyncTask;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// 控制器,可以做视图跳转
//@Controller

@Slf4j

// @RestController = @Controller + @ResponseBody
@RestController

public class HelloController {

    // API接口访问映射
    // @RequestMapping("hello")

    // 前后端分离,不再使用JSP,SpringMVC会把返回的字符串渲染到视图,这里没有视图
    // 声明返回1个字符串类型
    // @ResponseBody

    // @GetMapping("hello")

    @PostMapping("hello")

    public String hello() {

        MyBean myBean = new MyBean("jack", 18, "五", "十八班");
        log.debug("debug...");
        log.info(myBean.toString());
        log.warn("warn...");
        log.error("error...");

        return "Hello World~";
    }

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("doAsyncTask")
    public Object doAsyncTask() {
        asyncTask.doMyTask();
        return "Hello doAsyncTask~";
    }


    @Autowired
    private Stu stu;
    @Autowired
    private SpringBootConfig springBootConfig;

    @GetMapping("getStu")
    public Object getStu() {
        return stu;
    }

    @GetMapping("getConfigStu")
    public Object getConfigStu() {
        return springBootConfig.stu();
    }

    @Autowired
    private UserConfig userConfig;

    @GetMapping("getUserConfig")
    public Object getUserConfig() {
        return userConfig;
    }


    @Value("${self.custom.config.requestUrl}")
    private String requestUrl;
    @Value("${self.custom.config.sdkSecret}")
    private String sdkSecret;
    @Value("${self.custom.config.values}")
    private String values;

    @GetMapping("getYmlConfig")
    public Object getYmlConfig() {
        return requestUrl + ";" + sdkSecret + ";" + values;
    }

}
