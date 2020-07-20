package com.haowaner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haowaner.domain.User;
import com.haowaner.domain.VO;
import com.sun.deploy.util.SessionState;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/index",params ="name")
    public String index(){
        System.out.println("......");
        return "success";
    }
    @RequestMapping("/index2")
    public ModelAndView index2(ModelAndView model){
        model.addObject("name","Jack");
        model.setViewName("success");
        return model;
    }
    @RequestMapping("/index3")
    public String index3(Model model){
        model.addAttribute("name","Jack");
        return "success";
    }
    //返回jackson字符串
    @RequestMapping("/index4")
    @ResponseBody
    public String index4() throws JsonProcessingException {
        User user = new User();
        user.setAge(20);
        user.setName("Rose");
        /*JSONObject jsonObject = new JSONObject();
        String s = jsonObject.fromObject(user).toString();
        return s;*/
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        return s;
    }
    //将对象转为字符串
    @RequestMapping("/index5")
    @ResponseBody
    public User index5(){
        User user = new User();
        user.setName("Rose");
        user.setAge(12);
        return user;
    }
    @RequestMapping("/index6")
    @ResponseBody
    public String index6(){
        User user = new User();
        user.setAge(20);
        user.setName("LOL");
        String s = new JSONObject().fromObject(user).toString();
        return s;
    }
    //普通对象
    @RequestMapping("/index7")
    @ResponseBody
    public User index7(){
        User user = new User();
        user.setAge(12);
        user.setName("Pool");
        return user;
    }
    //map集合
    @RequestMapping("/index8")
    @ResponseBody
    public Map<String,Object> index8(){
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("type","success");
        ret.put("msg","成功！");
        return ret;
    }
    //请求  参数是基本数据类型
    @RequestMapping("/index9")
    @ResponseBody
    public void index9(String name,String age){
        System.out.println(name+" "+age);
    }
    //请求
    @RequestMapping("/index10")
    @ResponseBody
    public void index10(String name,Integer age){
        System.out.println(name+" "+age);
    }
    //请求 参数是javaBean
    @RequestMapping("/index11")
    @ResponseBody
    public void index11(User user){
        System.out.println(user);
    }
    //请求是数组
    @RequestMapping("/index12")
    @ResponseBody
    public void index12(String[] strs){
        System.out.println(Arrays.asList(strs));
    }
    //请求参数是vo 值对象
    @RequestMapping("/index13")
    @ResponseBody
    public void index13(VO vo){
        System.out.println(vo);
    }
    //直接使用userList集合 /springMvc2/user/index14

    @RequestMapping("/index14")
    @ResponseBody
    public void index14(@RequestBody List<User> userList){
        System.out.println(userList);
    }
    //测试@RequestParam 前台必须要传name属性的参数,如果说有默认值 可传可不传 ,required = false
    @RequestMapping("/index15")
    @ResponseBody
    public void index15(@RequestParam(value="name",required = false,defaultValue = "name") String name,
                        @RequestParam(value ="nianling",required =false,defaultValue ="") Long age){
        System.out.println(name+" "+age);
    }
    //测试restFul风格
    @RequestMapping("/index16/{id}/{name}")
    @ResponseBody
    public void index16(@PathVariable("id") Long id,
                        @PathVariable(value = "name") String name){
        System.out.println(id+" "+name);
    }
    //@RequestHeader @CookieValue
    //练习@RequestHeader  每次请求都有请求头 以可key和value的形式存在
    @RequestMapping("/index17")
    @ResponseBody
    public void index17(@RequestHeader(value ="User-Agent") String user_agent){
        System.out.println(user_agent);
    }
    //练习@CookieValue
    @RequestMapping("/index18")
    @ResponseBody
    public void index18(@RequestHeader(value = "Cookie") String cookie,
                        @CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println(cookie+" "+sessionId);
    }
    //自定义类型转化器
    @RequestMapping("/index19")
    @ResponseBody
    public void index19(Date date){
        System.out.println(date);
    }
    //文件上传
    @RequestMapping("/index20")
    @ResponseBody
    public void index20(String filename, MultipartFile uploadfile, HttpServletRequest request) throws IOException {
        System.out.println(filename);
        String originalFilename = uploadfile.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        // uploadfile.transferTo(new File(path, originalFilename));
        uploadfile.transferTo(new File(path+originalFilename));
    }
    //文件上传至服务器
    @RequestMapping("/index21")
    //@ResponseBody
    public String index21(String filename, MultipartFile uploadfile) throws Exception {
        System.out.println(filename);
        String originalFilename = uploadfile.getOriginalFilename();
        String path = "http://localhost:9090/uploads/";
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + originalFilename);
        //上传图片
        webResource.put(uploadfile.getBytes()  );
        // uploadfile.transferTo(new File(path, originalFilename));
        //uploadfile.transferTo(new File(path+originalFilename));
        return "success";
    }
}