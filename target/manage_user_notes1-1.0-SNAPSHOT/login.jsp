        <%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/4/2021
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="shortcut icon" href="img/favicon.%20ico" />
  <link rel="stylesheet" href="./css/login_css.css">

<title>login</title>
  <link rel="stylesheet" href="ic/themify-icons/SVG/themify-icons.css">

</head>
<body>
<% HttpSession session1 = request.getSession();
session1.setAttribute("infnote","");%>

<h2>personal note</h2>

<form action="hello-servlet" method="get">

  <div class="container">
    <%


      String edit="";
      String  error = (String) request.getAttribute("check");
      if (request.getAttribute("check") == "1") {
       edit = " username hoặc password không đúng ,mời nhập lại";
      }
      ;%>
    <p id="alet" class="edit"><%=edit%></p>
    <label ><b>username</b></label>
     <input  class="input4" type="text" placeholder="Enter Username" name="username" required>


    <label ><b>Password</b></label>
    <input class="input5" type="password" placeholder="Enter Password" name="password" required>


    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>

    <span  class="psw">Forgot <a href="forgotpass.jsp">password?</a></span>
    <span class="psw"> <a href="createpassword.jsp">create a account</a></span>
  </div>
</form>

</body>
<script type="text/javascript">
  if( $(document).find('#alet').text()===" username hoặc password không đúng ,mời nhập lại"){
    var inputr = document.querySelector('.input4');

      inputr.classList.add('error');
    var inputr1 = document.querySelector('.input5');

    inputr1.classList.add('error');
    }

</script>
</html>