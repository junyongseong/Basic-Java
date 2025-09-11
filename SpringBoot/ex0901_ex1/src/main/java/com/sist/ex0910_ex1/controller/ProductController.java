package com.sist.ex0910_ex1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0910_ex1.repository.ProductRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.sist.ex0910_ex1.store.Category1JPO;
import com.sist.ex0910_ex1.store.ProductJPO;

import org.springframework.web.bind.annotation.RequestParam;

import com.sist.ex0910_ex1.repository.Category1Repository;



@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Category1Repository category1Repository;

    @GetMapping("/add")
    public String add() {
        ProductJPO p1= ProductJPO.builder()
        .pName("비상").pCompany("sist")
        .category1(1)
        .build();
        productRepository.save(p1);

        return "insert ok!";
    }

    @GetMapping("/clist")
    public String getClist() {

        List<Category1JPO> list  = category1Repository.findAll();

        StringBuilder sb = new StringBuilder();

        for(Category1JPO cvo :list){
            sb.append(cvo.getIdx());
            sb.append("/");
            sb.append(cvo.getCName());
            sb.append("<br/");
            List<ProductJPO> pList =cvo.getPList();
            for(ProductJPO pvo :pList){
                sb.append("&nbsp;&nbsp;&nbsp;");
                sb.append(pvo.getPNum());
                sb.append(".");
                sb.append(pvo.getPName());
                sb.append("<br/>");
            }
        }
        
        return sb.toString();
    }
    
    
}
