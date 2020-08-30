package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.service.RegisterService;

@Controller
public class MainController {

	@Autowired
	RegisterService resService;


	/* 권한 상관 X */
	@RequestMapping(value="/main")
	public String main() {
		return "all/main";
	}

	@RequestMapping(value="/login")
	public String login() {
		return "all/login";
	}

	@RequestMapping(value="/register")
	public String register() {
		return "all/register";
	}

	@RequestMapping(value="/register.do")
	public String register(Model m, @RequestParam("id")String id, @RequestParam("password")String password, @RequestParam("name")String name, @RequestParam("gender")String gender, @RequestParam("address")String address, @RequestParam("phone")String phone, @RequestParam("favorite")String favorite) throws Exception{
		RegisterDTO resDTO= new RegisterDTO(id, password, name, gender, address, phone, favorite);
		resService.joinUser(resDTO);
		m.addAttribute("id", id);
		return "all/authmail";
	}

	@RequestMapping(value="/authmail", method = RequestMethod.GET)
	@ResponseBody
	public String authmail(String id){
		String authCode = resService.authMail(id);
		
		System.out.println("authCode : "+ authCode);
		return authCode;
	}

	@RequestMapping(value="/authmail.do", method = RequestMethod.POST)
	public String authmail2(String id) throws Exception {
		RegisterDTO resDTO = new RegisterDTO(id);
		resService.authSuccess(resDTO);
		return "all/main";
	}


	@RequestMapping(value="/game_1", method=RequestMethod.GET)
	public String game_1() {
		return "all/game_1";
	}

	/* 유저 */
	@RequestMapping(value="/main_user", method=RequestMethod.GET)
	public String main_user() {
		return "user/main_user";
	}

	@RequestMapping(value="/mypage_user", method=RequestMethod.GET)
	public String mypage_user() {
		return "user/mypage_user";
	}

	/* 관리자 */

	@RequestMapping(value="/main_admin", method=RequestMethod.GET)
	public String main_admin() {
		return "admin/main_admin";
	}

	@RequestMapping(value="/mypage_admin", method=RequestMethod.GET)
	public String mypage_admin() {
		return "admin/mypage_admin";
	}

	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String upload() {
		return "admin/upload";
	}

	/* 슈퍼 관리자 */

	@RequestMapping(value="/main_super", method=RequestMethod.GET)
	public String main_super() {
		return "super/main_super";
	}

	@RequestMapping(value="/dashboard_1", method=RequestMethod.GET)
	public String dashboard_1() {
		return "super/dashboard_1";
	}

	@RequestMapping(value="/dashboard_2", method=RequestMethod.GET)
	public String dashboard_2() {
		return "super/dashboard_2";
	}
}
