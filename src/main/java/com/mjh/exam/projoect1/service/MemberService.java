package com.mjh.exam.projoect1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.repository.MemberRepository;
import com.mjh.exam.projoect1.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member getMemberById(String loginId) {
		return memberRepository.getMemberById(loginId);
	}

	public void dojoin(String loginId, String loginPw, String name, String nickname, String email,
			String cellphoneNo) {
		
		memberRepository.dojoin(loginId,loginPw,name,nickname,email,cellphoneNo);
	}

	public Member getMemberById(int loginedMemberId) {
		return memberRepository.getMemberByMemberId(loginedMemberId);
	}

}
