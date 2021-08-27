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
	private boolean isLogined;
	@Getter
	private int loginedMemberId;
	@Getter
	private Member loginedMember;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession Session;
	
	public Rq(HttpServletRequest req,HttpServletResponse resp,MemberService memberService) {
		this.req = req;
		this.resp = resp;
		this.Session = req.getSession();
		
		boolean isLogined = false;
		int loginedMemberId =0;
		Member loginedMember = null;
		
		if(Session.getAttribute("loginedMemeberId") != null) {
			isLogined = true;
			loginedMemberId = (int) Session.getAttribute("loginedMemberId");
			loginedMember = memberService.getMemberById(loginedMemberId);
		}
		
		this.isLogined = isLogined;
		this.loginedMemberId = loginedMemberId;
		this.loginedMember = loginedMember;
		
		
		this.req.setAttribute("rq", this);
	}

	public void login(Member member) {
		Session.setAttribute("loginedMemberId", member.getId());
	}

	public void logout() {
		Session.removeAttribute("loginedMemberId");
	}
}
