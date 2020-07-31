package com.mars.controller;

import com.mars.service.IProductService;
import com.mars.vo.Product;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Resource
    private IProductService iProductService;

    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @GetMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }
}
