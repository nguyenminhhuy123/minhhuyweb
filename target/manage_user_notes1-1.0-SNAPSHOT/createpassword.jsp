<%@ page import="java.security.Signature" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/5/2021
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.%20ico" />
    <link rel="stylesheet" href="./css/createacc_css.css">
    <title>create acc</title>

</head>
<body>

<h2> CREATE A ACOUNT</h2>

<form action="createaccount" method="get">


    <div class="container">
        <label ><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label ><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password1" required>
        <label ><b>press Password again</b></label>
        <input type="password" placeholder="Enter Password" name="password2" required>

        <%
            String alert ="";

            if(request.getAttribute("cp1p2")=="false") {
                alert = "password nhâp không trùng khớp,mời nhập lại =)) ";
            }
            else if(request.getAttribute("cp1p2")=="userdup"){
                alert = "username đã tồn tại ,mời nhập lại =)) ";
            }
            else if(request.getAttribute("cp1p2")=="passdup"){
                alert = "password đã tồn tại ,mời nhập lại =)) ";
            }
            ;%>
        <p class="edit"> <%=alert%></p>


        <button type="submit">create</button>

    </div>


</form>
<a href="login.jsp"><button type="button" class="cancelbtn">Cancel</button></a>

</body>
</html>