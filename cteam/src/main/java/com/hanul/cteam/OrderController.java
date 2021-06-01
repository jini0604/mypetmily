package com.hanul.cteam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import order.OrderGoodsVO;
import order.OrderServiceImpl;
import order.OrderVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrderServiceImpl service;
	
	@RequestMapping("/orderPage")
	public String orderPage() {
		
		
		return "order/orderSuccess";
	}
	
	
	@ResponseBody 
	@RequestMapping(value = "/orderSuccess", produces = "text/html; charset=utf-8")
	public String orderSuccess(OrderVO orderVo, OrderGoodsVO vo, HttpServletRequest req) {
		
		String success="<script type='text/javascript'>";
		
		if(service.order_insert(orderVo)) {
			success += "alert('주문이 완료되었습니다'); location='http://localhost:8089/cteam/orderPage'";
		}else {
			success+="alert('주문이 실패했습니다') histroy.go(-1)";
		}
		
		
		success+="</script>";
		
		return success;
	}	
	
	
}
