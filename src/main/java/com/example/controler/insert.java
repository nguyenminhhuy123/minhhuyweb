package com.example.controler;

import idao.inotedao;
import impledao.notedao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet(name = "Servlet3", value = "/insert")
public class insert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Timestamp instant= Timestamp.from(Instant.now());
        inotedao inotedao =new notedao();
        String iduser= (String)session.getAttribute("user");
        String content = request.getParameter("insertcontentf");
        String notename =request.getParameter("insertnotef");
        String createdatime =instant.toString();
        inotedao.insertnote(iduser,content,notename,createdatime);
        response.sendRedirect("loader");
    }
}
