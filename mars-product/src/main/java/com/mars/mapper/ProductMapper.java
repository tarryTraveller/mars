package com.mars.mapper;

import com.mars.vo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductMapper {

    boolean create(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
}
