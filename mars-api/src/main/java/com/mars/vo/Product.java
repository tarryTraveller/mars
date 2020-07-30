package com.mars.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class Product implements Serializable{

    private Long productId;
    private String productName;
    private String productDesc;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
