package com.mars.controller;


import com.mars.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
    public static final String PRODUCT_TOPIC = "MARS-PRODUCT";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders httpHeaders;
    @Resource
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/product/list")
    public  Object listProduct() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());

        URI uri = URI.create(String.format("http://%s:%s/product/list/" ,
                serviceInstance.getHost(), serviceInstance.getPort()));
        System.out.println(uri);
        List<Product> list = restTemplate.exchange(uri,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;
    }

}
