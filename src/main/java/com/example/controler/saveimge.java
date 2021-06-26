package com.example.controler;

import impledao.notedao;
import impledao.userdao;
import model.usermodel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.note_service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "Servlet7", value = "/saveimage")
public class saveimge extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = null;
        String text ="sai";


            try {


                DiskFileItemFactory factory = new DiskFileItemFactory();

                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(repository);


                ServletFileUpload upload = new ServletFileUpload(factory);


                List<FileItem> items = upload.parseRequest(request);

                Iterator<FileItem> iter = items.iterator();
                HashMap<String, String> fields = new HashMap<>();
                while (iter.hasNext()) {
                    FileItem item = iter.next();

                    if (item.isFormField()) {
                        fields.put(item.getFieldName(), item.getString());

                    } else {
                        filename = item.getName();
                        if (filename == null || filename.equals("")) {
                            break;
                        } else {
                            Path path = Paths.get(filename);
                            String storepath = servletContext.getRealPath("/uploads");
                            File uploadfile = new File(storepath + "/" + path.getFileName());
                            item.write(uploadfile);

                        }

                    }
                }

            } catch (Exception e) {

            }
            if((filename.equals(""))||(filename.equals(null)) ){
                response.sendRedirect("loader");
            }
            else {
                text = filename;
                HttpSession session = request.getSession();
                String iduser = (String) session.getAttribute("user");
                File file = new File("C:\\Users\\PC\\IdeaProjects\\Manage_user_notes\\target\\Manage_user_notes-1.0-SNAPSHOT\\uploads\\" + filename);
                FileInputStream fileInputStream = new FileInputStream(file);
                userdao notedao = new userdao();
                notedao.insertimage(fileInputStream, text, iduser);

                response.sendRedirect("loader");

            }
        }


}
