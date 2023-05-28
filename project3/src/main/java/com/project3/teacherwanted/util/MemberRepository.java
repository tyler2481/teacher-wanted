package com.project3.teacherwanted.util;

import com.project3.teacherwanted.model.vo.MemberVo;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<MemberVo, Integer> {
    MemberVo findByMemAccount(String account);
}
