<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css?v="<%=new java.util.Date().getTime() %>">
<style type="text/css">
	li {text-align: center;}
	.btn-login{	line-height: 40px; margin:5px auto; box-shadow: 2px 2px 2px #969696; font-size:13px;  border: 1px solid #000000; color:white; background-color: black; width:385px; height: 40px; display: block; }
	.btn-signin{ line-height: 40px; margin:5px auto; box-shadow: 2px 2px 2px #969696; font-size:13px;  border: 1px solid #000000; color:black; background-color: white; width:385px; height: 40px; display: block;  }
</style>
</head>
<body>


	<br>
		<c:choose>
			<c:when test="${sessionId != null}">
				<h2>네이버 아이디 로그인 성공하셨습니다!!</h2>
				<h3>'${sessionId}' 님 환영합니다!</h3>
				<h3>
					<a href="logout">로그아웃</a>
				</h3>
			</c:when>
			<c:otherwise>
				<div class="login">
					<ul class="login-ul" style="overflow: hidden;">
							<li><h3>로그인</h3></li>
							<br/>
							<li>
								<span>
								<input type="text" style="margin-bottom: 10px; width:356px; outline-color:pink; border: 1px solid #7e7e7e;  padding: 0 20px; height:40px;" id="userid" placeholder="아이디"/>		<br/>
								<input onkeypress="if(event.keyCode==13){go_login()}" style=" outline-color:pink; width:356px; border: 1px solid #7e7e7e; padding:0 20px; height:40px;" type="password" id="userpwd" placeholder="비밀번호"/>
								</span>	
							</li>
							
						
							<li style="margin-top:10px;  float: right;" ><a href="idFind" style="font-size: 13px;">아이디찾기 ｜ 비밀번호 찾기</a></li>
							
							<li style="margin:50px 0 10px 0; text-align: center;"><a class='btn-login' onclick="go_login()">로그인</a></li>
							<li style="margin-bottom:10px; text-align: center;"><a href="email.do" class='btn-signin'>회원가입</a></li>
					</ul>
			
				<!-- 네이버 로그인 창으로 이동 -->
				<div id="naver_id_login" style="text-align: center">
					<a href="${url}"> <img width="223"
						src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" /></a>
				</div>
				<br>
			</div>	
				
			</c:otherwise>
		</c:choose>

	

<script type = "text/javascript" src = "https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 
 
 
 
 
<!-- <script type="text/javascript">
 
         var naver_id_login = new naver_id_login("5KDJ2AowQdWU418eNmvz", "http://localhost:8089/cteam/");    // Client ID, CallBack URL 삽입
                                            // 단 'localhost'가 포함된 CallBack URL
         var state = naver_id_login.getUniqState();
        
         naver_id_login.setButton("white", 4, 40);
         naver_id_login.setDomain("http://localhost:8089/cteam/loginPage");    //  URL
         naver_id_login.setState(state);
         naver_id_login.setPopup();
         naver_id_login.init_naver_id_login();
 
</script>
 -->
	

<script type="text/javascript">
function go_login(){
	if($("#userid").val()==''){
		alert('아이디를 입력하세요');
		$("#userid").focus();
		return;
	}else if($('#userpwd').val()==''){
		alert('비밀번호를 입력하세요');
		return;
	}

	$.ajax({
		url: 'login',
		data: {userid:$("#userid").val(), userpwd:$("#userpwd").val()},
		success:function(data){
				if(data){
				//	alert("로그인성공");
					location.href='/cteam/';
				}else{
					alert("아이디나 비밀번호가 일치하지않습니다");
				}
			},	
		error:function(req,text){
			alert(text+':'+req.status);
		}

	});

	
}


</script>
</body>
</html>