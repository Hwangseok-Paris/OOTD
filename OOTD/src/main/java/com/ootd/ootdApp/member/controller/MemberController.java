package com.ootd.ootdApp.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

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
	public String memberJoinEnd() {
		System.out.println("joinEnd 확인");
		return "redirect:/";
	}
	
	@RequestMapping("member/memberLogin.do")
	public String memberLogin() {
		System.out.println("login 확인");
		return "redirect:/";
	}
}
