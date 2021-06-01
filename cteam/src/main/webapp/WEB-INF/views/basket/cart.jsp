<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<style>

th.th-top {
	padding-bottom: 10px;
	border-bottom: 1px solid #E1E1E1;
}

td.th-middle-top {
	padding-bottom: 10px;
	border-bottom: 1px solid #E1E1E1;
	text-align: left;
	color: #000000;
	font-size: 20px;
	font-weight: bold;
}

td.th-middle {
	color: #777777;
	padding: 10px;
	border-bottom: 1px solid #E1E1E1;
}

table {
	margin: 50px auto;
}

input {
	border: 1px solid #dedede;
	color: #565656;
	height: 16px;
	outline: none;
}
</style>
</head>

<body>
	<div>
		<h1>Cart</h1>

	<form action="order.sh" method="post">
			<table style="margin: 0 auto;">
				<tr style="color: #777; font-size: 12px;">
					<th class="w-px120 th-top">사진</th>
					<th class="w-px350 th-top">상품명</th>
					<th class="w-px150 th-top">옵션</th>
					<th class="w-px160 th-top">가격</th>
					<th class="w-px120 th-top">수량</th>
					<th class="w-px200 th-top">합계</th>
				</tr>
		
				<c:forEach var="vo" items="${list }" varStatus="status">
					
					
					<c:set var="options" value="${fn:split(vo.option_info, '/')}" />
					<c:forEach begin="0" end="${fn:length(options)-1}"
						varStatus="optionsStatus">
						<c:set var="option" value="${options[optionsStatus.index]}" />
						<c:set var="detail" />
						<c:forEach begin="0" end="${fn:length(option)-1}"
							varStatus="optionStatus">
							<c:set var="detail" value="${fn:split(option, '@')}" />
						</c:forEach>
						<tr>
						<%-- 	<td><img class="imgpath"
								src="<c:url value='/' />${vo.item_imgpath }"
								style="width: 80; height: 113px;"></td>
	
							<td>${vo.item_name }</td> --%>
							<td>${detail[0]}</td>
<%-- 							<td>${vo.item_price }원</td>
 --%>							<td>${detail[1]}</td>
					<%-- 		<td>${ vo.item_price * detail[1]}원</td> --%>
	
						</tr>
					</c:forEach>
					
					<tr
						style="background-color: #F4F4F4; color: #6d6c71; font-size: 12dp; text-align: right;">
						<td colspan="6" style="padding: 10px;" class="right">total
							cost : ${vo.totalPrice } 원</td>
					</tr>
					
				</c:forEach>	
			</table>


</body>
</html>