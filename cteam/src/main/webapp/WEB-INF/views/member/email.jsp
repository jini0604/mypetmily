<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
 <!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 -->
 <link rel="stylesheet" type="text/css" href="css/common.css?v="<%=new java.util.Date().getTime() %>">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
</head>
<body>



	<table style="margin-bottom:150px; border-collapse: collapse;" width="300" height="300" align="center">
		<div style="margin-top:100px; text-align:center; color: #777777;">이메일을 인증 받아야 회원가입 단계로 넘어갈 수 있습니다.</div> <br> <br>    
 
       
 
        
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                    <form action="auth.do" method="post">
                    
                    <center>
                        <br>
                        <div>
                            	<input style="outline-color:pink; width:250px; height: 40px; border: none;" type="email" name="e_mail"
                                placeholder="  이메일주소를 입력하세요. ">
                        </div>                                                    
 
                        <br> <br>
                        <button style="border: 1px solid #000000; background-color: #000000; width:300px; height: 30px; color: white;" type="submit" name="submit">인증번호 발송</button>
 
                        </div>
                    </td>
                </tr>
                    </center>
            </table>
        </form>
	</table>
	

</body>
</html>