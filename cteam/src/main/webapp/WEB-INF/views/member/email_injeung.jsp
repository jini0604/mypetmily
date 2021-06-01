<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css?v="<%=new java.util.Date().getTime()%>">

</head>
<body>

	<table style="margin-bottom:150px; collapse;" width="300" height="300" align="center">
	
		<div style=" margin-top:100px; color: #565656; text-align: center;">
		입력한 이메일로 발송된 인증번호를 입력하세요. <br/>(인증번호가 맞아야 회원가입으로 넘어가실 수 있습니다.)
		</div>



		<div style="text-align: center;">
			<tr>
				<td>
					<center>
						<form action="join_injeung.do${dice}" method="post">
							<center>
								<br>
								<div style="color:pink">
									인증번호 입력  <br/> <br/> <br/>
									 <input type="number" name="email_injeung"
										placeholder="  인증번호를 입력하세요. "
										style="outline-color:pink; width:250px; height: 40px; border: none;">
								</div>
								<input type="hidden" name="tomail" value="${tomail }">
								<br> <br>
								<button type="submit" name="submit"
								style="border: 1px solid #000000; background-color: #000000; width:300px; height: 30px; color: white;">인증번호 전송</button>
					</div>
			</td>
		</tr>
		</center>
	</table>
	</form>
	</table>



</body>
</html>
