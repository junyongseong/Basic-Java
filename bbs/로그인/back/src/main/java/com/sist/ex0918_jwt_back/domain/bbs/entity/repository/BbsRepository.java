package com.sist.ex0918_jwt_back.domain.bbs.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.ex0918_jwt_back.domain.bbs.entity.Bbs;


@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long>{

}
