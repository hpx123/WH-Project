package com.wh.pojo;

import java.util.Date;

public class Product {
    private Integer id;

    private Integer userId;

    private String proname;

    private String productImage;

    private Date productionDate;

    private Date expirationDate;

    private Integer exptime;

    private Date addDate;

    private Integer stock;

    private String property;

    private Integer status;

    private String detail;

    private Date createTime;

    private Date updateTime;

    public Product(Integer id, Integer userId, String proname, String productImage, Date productionDate, Date expirationDate, Integer exptime, Date addDate, Integer stock, String property, Integer status, String detail, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.proname = proname;
        this.productImage = productImage;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.exptime = exptime;
        this.addDate = addDate;
        this.stock = stock;
        this.property = property;
        this.status = status;
        this.detail = detail;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getExptime() {
        return exptime;
    }

    public void setExptime(Integer exptime) {
        this.exptime = exptime;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}