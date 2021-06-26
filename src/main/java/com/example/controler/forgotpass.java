package com.example.controler;

import idao.iuserdao;
import impledao.userdao;
import model.usermodel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet6", value = "/forgotpass")
public class forgotpass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iuserdao iuserdao =new userdao();

        String p1= request.getParameter("password1");
        String p2=request.getParameter("password2");
        String username=  request.getParameter("username");

        if(iuserdao.getuserbyuserid(username).size() != 0) {
            if (p1.equals(p2)) {
                if(iuserdao.checkpassword(p1).size()!=0){
                    request.setAttribute("check","falsepass1");
                    request.getRequestDispatcher("forgotpass.jsp").forward(request,response);

                }
                else {
                    iuserdao.updatepassword_byiduser(p1,username);
                    response.sendRedirect("login.jsp");
                }

            } else {
                request.setAttribute("check","falsepass");
                request.getRequestDispatcher("forgotpass.jsp").forward(request,response);


            }
        }
        else{
            request.setAttribute("check","falseuser");
            request.getRequestDispatcher("forgotpass.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
