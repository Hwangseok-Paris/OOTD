package com.ootd.ootdApp.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/member/memberJoin.do")
	public String memberJoin() {
		
		return "member/memberJoin";
	}
	
	@RequestMapping("/member/joinAccept.do")
	public String memberJoinAccept() {
		
		return "member/joinAccept";
	}
	
	@RequestMapping("member/memberJoinEnd.do")
	public String memberJoinEnd() {
		
		return "index";
	}
	
	
	
	
}
