package com.wh.controller;


import com.google.common.collect.Maps;
import com.wh.common.Const;
import com.wh.common.ResponseCode;
import com.wh.common.ServerResponse;
import com.wh.pojo.Product;
import com.wh.pojo.User;
import com.wh.service.IFileService;
import com.wh.service.IProductService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    private IFileService iFileService;

    /**
     * 通过用户id获取商品
     */

    @RequestMapping(value = "addProduct.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addProduct(Product product){
        return iProductService.saveOrUpdateProduct(product);
    }

    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Product>> addProduct(Integer userID){
        return null;
    }


}
