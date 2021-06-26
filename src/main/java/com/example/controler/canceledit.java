package com.example.controler;

import model.notemodel;
import service.note_service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet13", value = "/cancledit")
public class canceledit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();



        String idnotef = request.getParameter("idnote");


        String id = request.getParameter("id");
        String page =request.getParameter("page");
        int pag1 =Integer.parseInt(page);
        int idnote =Integer.parseInt(idnotef);
        int id1 = Integer.parseInt(id);

        note_service note_service =new note_service();

        notemodel notemodel=   note_service.getnotebyid(idnote).get(0);
        String nname = notemodel.getNotename();
        String ct = notemodel.getContent();
        String time = notemodel.getTime();
        String edittime = "";
        if(notemodel.getEdittime()!=null){
            edittime= notemodel.getEdittime();
        }

        out.println(" <div class=\"note\"id=\""+id+"\">\n" +
                "            <div class=\"manct\">\n" +
                "                 <p class=\"edited\">"+edittime +" <p>\n"+
                "                <h2 class=\"get\">"+ nname +"</h2>\n" +
                "                <p class=\"timeago\"> "+time+"<p>\n" +
                "                <p class=\"get1\">"+ct+"</p>\n" +
                "                <a class=\"cha\" > <button class=\"decor\"> View</button> </a>\n" +
                "                <a class=\"edit\" onclick=\"addclass("+id1+")\" title=\"Edit\" data-toggle=\"tooltip\" > <button class=\"decor\">Edit</button> </a>\n" +
                "                <a class=\"cha1\" href=\"#\" onclick=\"alertmethod("+notemodel.getIdnote()+","+pag1+","+id1+")\"> <button class=\"delete decor\"> Delete</button> </a>\n" +
                "                <a class=\"cancel1\" onclick=\"cancelclick("+notemodel.getIdnote()+","+id1+","+pag1+")\" ><button class=\"decor\">cancel</button></a>\n" +
                "                <a class=\"oke\"  onclick=\"editmethod("+notemodel.getIdnote()+","+id1+","+pag1+")\"><button class=\"decor\">oke</button></a>\n" +
                "            </div>\n" +
                "        </div>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
