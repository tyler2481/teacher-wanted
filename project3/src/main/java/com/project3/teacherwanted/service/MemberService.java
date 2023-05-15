package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.dto.MemberRegisterRequest;
import com.project3.teacherwanted.model.vo.MemberVo;

public interface MemberService {
    MemberVo findById(Integer memid);
    MemberVo findByAccount(String account);
    void save(MemberVo member);
    void update(MemberVo member);
    void deleteById(Integer id);
}
