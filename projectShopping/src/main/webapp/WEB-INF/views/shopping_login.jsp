<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>main</title>

    <link rel="stylesheet" href="resources/home.css/login.css">
    

</head>
<body>
<jsp:include page="./shopping_top.jsp"></jsp:include>

  <form action="loginConfirm.do" method="post">

    <div id="login1">
    <input type="text" name="userid" placeholder="���̵� �Է�"><br>
    <input type="password" name="pwd" placeholder="��й�ȣ �Է�"><br>
    <input type="submit" id="login" value="�α���">
    <div id="lmsg">${msg}</div>
    </div>
    <div id="login2">
        <ul>
            <li><a href="findid.do">���̵� ã��</a></li>
            <li><a href="#">��й�ȣ ã��</a></li>
            <li><a href="signup.do">ȸ������</a></li>
        </ul>
    </div>
 </form>
     
  <jsp:include page="./shopping_footer.jsp"></jsp:include>   
     
  




</body>
</html>