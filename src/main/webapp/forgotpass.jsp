<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/5/2021
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.%20ico" />
    <link rel="stylesheet" href="./css/forgotacc-css.css">
    <title>forgot acc</title>

</head>
<body>

<h2>PASSWORD RECOVERY</h2>
`
<form action="forgotpass" method="get">

    <div class="container">
        <label ><b>press your Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label ><b>New Password</b></label>
        <input type="password" placeholder="Enter Password" name="password1" required>
        <label ><b>Press new Password again</b></label>
        <input type="password" placeholder="Enter Password" name="password2" required>
        <%
        String alert="";
        if(request.getAttribute("check")=="falsepass"){
            alert="password không trùng lặp , mời nhập lại";
        }
        else if(request.getAttribute("check")=="falseuser"){
            alert="username không tồn tại,mời nhập lại";
        }
        else if(request.getAttribute("check")=="falsepass1"){
            alert="password đã tồn tại mời nhập lại";
        }
        %>
        <p class="edit"><%= alert %></p>


        <button type="submit">recovery</button>

    </div>


</form>
<a href="login.jsp"><button type="button" class="cancelbtn">Cancel</button></a>

</body>
</html>