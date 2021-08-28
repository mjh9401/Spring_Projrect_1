package com.mjh.exam.projoect1.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mjh.exam.projoect1.service.MemberService;

import lombok.Getter;

@Component
@Scope(value="request",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Rq {
	@Getter
	private boolean isLogined = false;
	@Getter
	private int loginedMemberId = 0 ;
	@Getter
	private Member loginedMember = null;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession Session;
	private MemberService memberService;
	
	public Rq(HttpServletRequest req, HttpServletResponse resp, MemberService memberService) {
		this.req = req;
		this.resp = resp;
		this.Session = req.getSession();
		this.memberService = memberService;
		
		boolean islogined = false;
		int loginedMemberId = 0;
		Member loginedMember = null;
		
		if(Session.getAttribute("loginedMemberId") != null) {
			islogined = true;
			loginedMemberId = (int) Session.getAttribute("loginedMemberId");
			loginedMember = memberService.getMemberById(loginedMemberId);
		}
		
		this.loginedMemberId = loginedMemberId;
		this.isLogined = islogined;
		this.loginedMember = loginedMember;
		
		this.req.setAttribute("rq", this);
	}


	public void login(Member member) {
		Session.setAttribute("loginedMemberId", member.getId());
		//System.out.println("결과2 : "+ isLogined());
	}

	public void logoout() {
		Session.removeAttribute("loginedMemberId");
	}
	
	
}
