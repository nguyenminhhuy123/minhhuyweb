package com.example.controler;

import idao.inotedao;
import idao.iuserdao;
import impledao.notedao;
import impledao.userdao;
import model.notemodel;
import model.usermodel;
import service.note_service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@WebServlet(name = "Servlet2", value = "/loader")
public class loader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String iduser = (String)session.getAttribute("user");
       int index =0;


        String check = (String) session.getAttribute("login");
        String seach = request.getParameter("seachnote");

        if( (String) session.getAttribute("infnote") == null){
           session.setAttribute("infnote","");
        }
        else if( (String) session.getAttribute("infnote") != null){
            if(seach!=null){
                session.setAttribute("infnote",seach);
            }

        }

        note_service note_service = new note_service();
        notemodel notemodel =new notemodel();


            String page =  request.getParameter("page");
            if(page!=null) {

                int Page =Integer.parseInt(page);
                notemodel.setPage(Page);
            }


            index=notemodel.getPage();
            if(index ==1){
                index= 0;
            }
            else {
                index = (index-1)*6;
            }


String like = (String)session.getAttribute("infnote");
          notemodel.setListmodel(note_service.seachnoteautomactic( like, iduser,index));
           usermodel usermodel ;
           userdao userdao =new userdao();
           usermodel =userdao.getuserbyuserid(iduser).get(0);
           if(usermodel.getImage()==null){
               usermodel.setNamefileimage("images.png");
           }

            int total = (int) Math.ceil((double) note_service.getnotebyuserid(like,iduser).size()/6);
         notemodel.setTotalpage(total);
        request.setAttribute("Listnote",notemodel);
        request.setAttribute("nameuser",iduser);
        request.setAttribute("usermodel",usermodel);

        request.getRequestDispatcher("noteform.jsp").forward(request,response);}




}
