package com.hanul.cteam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Basket.BasketServiceImpl;
import Basket.CartVO;
import member.MemberVO;

@Controller
public class BasketController {
	
	@Autowired BasketServiceImpl service;

	//장바구니로 가기
	@RequestMapping("/cart.bs")
	public String go_cart(HttpSession session,Model model) {
		session.setAttribute("category", "bs");

		MemberVO login = (MemberVO)session.getAttribute("login_info");
		
		String member_id=login.getMember_id();
		
		model.addAttribute("list",service.cart_select(member_id));
			
		
		return "basket/cart";
	}
	
	@RequestMapping("/cartAdd")
	@ResponseBody
	public boolean CartAdd(@RequestParam("option_info") String option_info, @RequestParam("totalPrice") String totalPrice,
							@RequestParam("item_num") String item_num,HttpSession session){
		
	
		MemberVO login = (MemberVO)session.getAttribute("login_info");
		
		String member_id=login.getMember_id();
		
		CartVO vo= new CartVO();
		
		vo.setItem_num(item_num);
		vo.setOption_info(option_info);
		vo.setTotalPrice(totalPrice);
		vo.setMember_id(member_id);
			
		
		return service.cart_insert(vo);
		
	}
	
}
