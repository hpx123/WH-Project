package com.wh.controller;


import com.google.common.collect.Maps;
import com.wh.common.Const;
import com.wh.common.ResponseCode;
import com.wh.common.ServerResponse;
import com.wh.pojo.User;
import com.wh.service.IFileService;
import com.wh.service.IUserService;
import com.wh.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IFileService iFileService;
    /**
     * 登陆
     */
    @RequestMapping(value = "login.do")
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
       ServerResponse<User> response = iUserService.login(username, password);

       if(response.isSuccess() == true){
            session.setAttribute(Const.CURRENT_USER, response.getData());
       }
       return response;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do")
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpSession session,@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request){
        //User user = (User)session.getAttribute(Const.CURRENT_USER);
        System.out.println(file.getOriginalFilename());
        String targetFileName = iFileService.upload(file,"/home/upload/");
        //String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
        System.out.println(targetFileName);
        Map fileMap = Maps.newHashMap();
        //fileMap.put("uri",targetFileName);
        fileMap.put("url", targetFileName);
        return ServerResponse.createBySuccess(fileMap);
    }

}
