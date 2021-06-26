package com.example.controler;

import idao.inotedao;
import impledao.notedao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/delete")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        inotedao inotedao =new notedao();

        String number = request.getParameter("num");
        int haa =Integer.parseInt(number);






        session.setAttribute("num",haa);
        String idnote = request.getParameter("idnote");
        inotedao.delete(idnote);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
