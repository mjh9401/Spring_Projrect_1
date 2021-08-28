package com.mjh.exam.projoect1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.Ut.Ut;
import com.mjh.exam.projoect1.service.MemberService;
import com.mjh.exam.projoect1.vo.Member;
import com.mjh.exam.projoect1.vo.Rq;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private Rq rq;

	
	@RequestMapping("/usr/member/join")
	@ResponseBody
	public String join(String loginId, String loginPw, String name, 
			String nickname, String email, String cellphoneNo) {
		
		if(loginId.isEmpty() || loginId.trim().length()==0) {
			return "로그인 아이디를 입력해주세요";
		}
		if(loginPw.isEmpty() || loginPw.trim().length()==0) {
			return "비밀번호를 입력해주세요";
		}
		if(name.isEmpty() || name.trim().length()==0) {
			return "이름을 입력해주세요";
		}
		if(nickname.isEmpty() || nickname.trim().length()==0) {
			return "닉네임을 입력해주세요";
		}
		if(email.isEmpty() || email.trim().length()==0) {
			return "이메일을 입력해주세요";
		}
		if(cellphoneNo.isEmpty() || cellphoneNo.trim().length()==0) {
			return "전화번호를 입력해주세요";
		}
		
		memberService.dojoin(loginId,loginPw,name,nickname,email,cellphoneNo);
				
		return name+"님 회원가입 완료되었습니다.";
	}
	
	@RequestMapping("/usr/member/login")
	public String login(Model model) {
		model.addAttribute("rq", rq);
		
		return "usr/member/login";
	}
	
	@RequestMapping("/usr/member/dologin")
	@ResponseBody
	public String dologin(String loginId,String loginPw) {
		
		if(rq.isLogined()) {
			return Ut.jsHistoryBack("이미 로그인중입니다.");
		}
		
		if(loginId.isEmpty() || loginId.trim().length()==0) {
			return Ut.jsHistoryBack("loginId를 입력해주세요");
		}
		
		if(loginPw.isEmpty() || loginId.trim().length()==0) {
			return Ut.jsHistoryBack("loginPw를 입력해주세요");
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			return Ut.jsHistoryBack("존재하지 않는 아이디입니다.");
		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}
		
		rq.login(member);
		
		
		return Ut.jsReplace(Ut.f("%s님 환영합니다.",member.getNickname()),"/");
	}
	
	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout(HttpSession session) {
				
		if(rq.isLogined() == false) {
			return "로그아웃상태 입니다.";
		}
		
		rq.logoout();
		
		return Ut.jsReplace("로그아웃됐습니다.", "/");
	}
	
}
