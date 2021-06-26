package com.example.controler;


import idao.inotedao;
import idao.iuserdao;
import impledao.notedao;
import impledao.userdao;
import model.notemodel;
import model.usermodel;
import service.note_service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.logging.FileHandler;

public class  test {

    public static void main(String[] args) throws Exception  {
        userdao userdao =new userdao();
        List<usermodel> list = userdao.getuserbyuserid("mhuy1");
        String name =list.get(0).getNamefileimage();
        byte[] file1 = list.get(0).getImage();
        FileOutputStream fileOutputStream =new FileOutputStream("dawd.jpg");
        fileOutputStream.write(file1);
        fileOutputStream.close();

    }
    }



