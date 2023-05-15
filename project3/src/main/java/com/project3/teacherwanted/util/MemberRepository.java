package com.project3.teacherwanted.util;

import com.project3.teacherwanted.model.vo.MemberVo;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface MemberRepository extends JpaRepository<MemberVo, Integer> {
    MemberVo findByMemAccount(String account);
}
