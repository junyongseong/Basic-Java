package com.sist.ex0910_ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.ex0910_ex1.store.ProductJPO;

@Repository
public interface ProductRepository extends JpaRepository<ProductJPO,Long>{//테이블+ 기본키의 자료형

    
}
