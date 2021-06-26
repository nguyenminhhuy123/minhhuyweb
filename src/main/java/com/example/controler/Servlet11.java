package com.example.controler;

import impledao.userdao;
import model.usermodel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Servlet11", value = "/Servlet11")
public class Servlet11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String iduser = (String)session.getAttribute("user");
        userdao userdao =new userdao();
        List<usermodel> list = userdao.getuserbyuserid(iduser);
        String name =list.get(0).getNamefileimage();
        byte[] file1 = list.get(0).getImage();
        FileOutputStream fileOutputStream =new FileOutputStream(name);
        fileOutputStream.write(file1);
        fileOutputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
