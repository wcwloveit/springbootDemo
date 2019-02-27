package com.springboot.chapter12.controller;

import com.springboot.chapter12.Utils.MD5;
import com.springboot.chapter12.pojo.ClientInfo;
import com.springboot.chapter12.pojo.DatabaseUser;
import com.springboot.chapter12.pojo.ResponseVo;
import com.springboot.chapter12.service.LogInfoService;
import com.springboot.chapter12.service.UserRoleService;
import com.springboot.chapter12.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Controller
public class WelcomeController {

    @Autowired
    private UserRoleService userRoleService = null;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private LogInfoService logInfoService;

//    @PostMapping("/login")
//    public String welcome6() {
//        return "success";
//    }

    @GetMapping("/success")
    public String welcome8() {
        return "success";
    }

    @GetMapping("/")
    public String welcome5() {
        return "welcome";
    }

    @GetMapping("/login")
    public String welcome7() {
        return "success";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/user/details")
    @ResponseBody
    public DatabaseUser getUser(String userName) {
        return userRoleService.getUserByName(userName);
    }

    @GetMapping("/user/welcome")
    public String userWelcome() {
        return "welcome";
    }

    @GetMapping("/login111")
    public String login() {
        return "login111";
    }

    @PostMapping("/login/page1")
    public void login1(HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        userDetailsService.loadUserByUsername(username);
    }

    @PostMapping("/getLogInfo")
    public ResponseVo getLogInfo(@RequestBody String clientName, @RequestBody String sign, Map<String, String> map) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ClientInfo clientInfo = logInfoService.findClientInfoByClientName(clientName);
        String salt = null;
        String key = null;
        if(clientInfo != null){
           salt = clientInfo.getSalt();
           key = clientInfo.getKey();
        }
        Set set = map.keySet();
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        Collections.sort(list);
       StringBuffer stringBuffer = new StringBuffer(key+salt);
       for (int i = 0;i <list.size();i++){
           stringBuffer.append(list.get(i) + map.get(list.get(i)));
       }
        String correctSign = MD5.encoderByMD5(stringBuffer.toString());
       if(sign != null && sign == correctSign){

       }else{

       }
       return null;
    }


    @GetMapping("/admin/welcome")
    public String adminWelcome() {
        return "success";
    }

    @GetMapping("/admin/welcome1")
    public String adminWelcome1() {
        return "welcome";
    }

    @GetMapping("/admin/welcome2")
    public String adminWelcome2() {
        return "welcome";
    }

    @GetMapping("/csrf/form")
    public String csrfPage() {
        return "csrf_form";
    }

    @PostMapping("/csrf/commit")
    @ResponseBody
    public Map<String, String> csrfCommit(String name, String describe) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("describe", describe);
        return map;
    }

}
