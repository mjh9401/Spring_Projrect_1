package com.mjh.exam.projoect1.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Member;

@Mapper
public interface MemberRepository {

	public Member getMemberById(@Param("loginId") String loginId);

	public void dojoin(@Param("loginId") String loginId,
			@Param("loginPw") String loginPw,@Param("name") String name, 
			@Param("nickname") String nickname,@Param("email") String email,
			@Param("cellphoneNo") String cellphoneNo);	

}
