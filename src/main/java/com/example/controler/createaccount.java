package com.example.controler;

import idao.iuserdao;
import impledao.userdao;
import model.usermodel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet5", value = "/createaccount")
public class createaccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iuserdao iuserdao =new userdao();
        usermodel  usermodel =new usermodel();
       String p1= request.getParameter("password1");
       String p2=request.getParameter("password2");
       String username=  request.getParameter("username");

       if(p1.equals(p2)){
           if( iuserdao.getuserbyuserid(username).size()==0){
               if(iuserdao.checkpassword(p1).size()==0){
                   iuserdao.insertuser(username,p1);
                   response.sendRedirect("login.jsp");
               }
               else{
                   request.setAttribute("cp1p2","passdup");
                   request.getRequestDispatcher("createpassword.jsp").forward(request,response);
               }
           }
           else {
               request.setAttribute("cp1p2","userdup");
               request.getRequestDispatcher("createpassword.jsp").forward(request,response);
           }


       }
       else{
           request.setAttribute("cp1p2","false");
        request.getRequestDispatcher("createpassword.jsp").forward(request,response);


       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
