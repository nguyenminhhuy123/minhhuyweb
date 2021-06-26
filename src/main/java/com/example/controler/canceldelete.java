package com.example.controler;

import idao.inotedao;
import impledao.notedao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet12", value = "/canceldele")
public class canceldelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        inotedao inotedao =new notedao();
        session.setAttribute("login","over");
        int indexpage = Integer.parseInt( request.getParameter("page"));
        session.setAttribute("Page",indexpage);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
