package com.wh.service.impl;

import com.github.pagehelper.PageInfo;
import com.wh.common.ServerResponse;
import com.wh.dao.ProductMapper;
import com.wh.dao.UserMapper;
import com.wh.pojo.Product;
import com.wh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse<String> saveOrUpdateProduct(Product product) {
        if(product.getId() != null){
            int rowCount = productMapper.updateByPrimaryKey(product);
            if(rowCount > 0){
                return ServerResponse.createBySuccess("更新产品成功");
            }
            return ServerResponse.createBySuccess("更新产品失败");
        }else{
            int rowCount = productMapper.insert(product);
            if(rowCount > 0){
                return ServerResponse.createBySuccess("新增产品成功");
            }
            return ServerResponse.createByErrorMessage("新增产品失败");
        }
    }

    @Override
    public ServerResponse<List<Product>> getProductByUserID(Integer userID) {
        if(userID == null){
            return ServerResponse.createByErrorMessage("获取商品信息失败，用户ID为空");
        }

        List<Product> products = productMapper.selectByUserID(userID);;
        if(products.isEmpty()){
            return ServerResponse.createBySuccessMessage("获取商品失败");
        }else if(products == null){
            return ServerResponse.createBySuccessMessage("您还没有添加任何商品信息");
        }

        return ServerResponse.createBySuccess(products);
    }


}
