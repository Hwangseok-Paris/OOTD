package com.ootd.ootdApp.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ootd.ootdApp.member.exception.MemberException;
import com.ootd.ootdApp.member.model.service.MemberService;
import com.ootd.ootdApp.member.model.vo.Member;

@SessionAttributes({"member"})
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@RequestMapping("/member/memberJoin.do")
	public String memberJoin() {
		
		return "member/memberJoin";
	}
	
	@RequestMapping("/member/brandJoin.do")
	public String brandJoin() {
		
		return "member/brandJoin";
	}
	
	
	@RequestMapping("/member/joinAccept.do")
	public String memberJoinAccept() {
		
		return "member/joinAccept";
	}
	
	@RequestMapping("member/memberJoinEnd.do")
	public String memberJoinEnd(
				SessionStatus status,
				Member member,
				Model model
			) {
		
		System.out.println("joinEnd 들어온 정보 : " + member);
		
		String pass1 = member.getMember_pw();
		String pass2 = bcrypt.encode(pass1);
		
		member.setMember_pw(pass2);
		
		int login_type = member.getLogin_type();
		
		
		try {
			
			int result = 0;
			
			if ( login_type == 1 ) result = memberService.insertBrandMember(member);
			else if ( login_type == 2 ) result = memberService.insertMember(member);
			
			String msg = "";
			String loc = "/";
			
			if ( result > 0 ) {
				msg = "회원가입 성공!";
			} else {
				msg = "회원가입 실패";
			}
			
			status.setComplete();
			
			model.addAttribute("loc", loc);
			model.addAttribute("msg", msg);
			
		} catch ( Exception e ) {
			
			System.out.println("회원가입 에러");
			
			throw new MemberException(e.getMessage());
		}
		
		return "common/msg";
	}
	
	
	@RequestMapping("member/memberLogin.do")
	public String memberLogin(
				@RequestParam String member_id,
				@RequestParam String member_pw,
				Model model
			) {
		
		System.out.println("login Access");
		
		Member result = memberService.selectOneMember(member_id);
		
		System.out.println("로그인 조회 결과 : " + result);
		
		String loc = "/";
		String msg = "";
		
		if ( result != null ) {
			
			if ( bcrypt.matches(member_pw, result.getMember_pw()) ) {
				
				msg = "로그인 성공";
				model.addAttribute("member", result);
				
			} else {
				msg = "비밀번호를 다시 확인해주세요.";	
			}
		} else {
			msg = "아이디를 다시 확인해주세요.";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "redirect:/";
	}
	
	
	
	
}
