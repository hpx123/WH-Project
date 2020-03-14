package com.wh.service;

import com.github.pagehelper.PageInfo;
import com.wh.common.ServerResponse;
import com.wh.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductService {
    ServerResponse<String> saveOrUpdateProduct(Product product);

    ServerResponse<List<Product>> getProductByUserID(Integer userID);

}
