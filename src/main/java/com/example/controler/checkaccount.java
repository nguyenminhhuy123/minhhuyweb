package com.example.controler;

import idao.inotedao;
import idao.iuserdao;
import impledao.notedao;
import impledao.userdao;
import model.notemodel;
import model.usermodel;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class checkaccount extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

       HttpSession session = request.getSession();

       String iduser = request.getParameter("username");
       String pwuser = request.getParameter("password");
        inotedao inotedao =new notedao();
        iuserdao iuserdao =new userdao();
        List<usermodel> list= iuserdao.getuserbyuseridandpass(iduser,pwuser);
        if( list.size()==0){
            request.setAttribute("check","1");
           request.getRequestDispatcher("login.jsp").forward(request,response);
        }
         else {
             session.setAttribute("num",3);
             session.setAttribute("user",iduser);
             session.setAttribute("password",pwuser);
             session.setAttribute("login","first");
             response.sendRedirect("loader");

        }





    }

    public void destroy() {
    }
}