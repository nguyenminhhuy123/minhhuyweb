<%@ page import="idao.inotedao" %>
<%@ page import="impledao.notedao" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/4/2021
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="./libjs/jquery.twbsPagination.js" type="text/javascript" ></script>
    <link rel="stylesheet" href="./css/noteformcss.css">
    <link rel="shortcut icon" href="img/favicon.%20ico" />

    <link rel="stylesheet" href="./ic/themify1-icons/themify-icons.css">
    <title>Todo app</title>
    <title>JSP - Hello World</title>
</head>


<body>
<div class="header">
    <h3>TodoApp</h3>
</div>

<div class="cv">
    <div class="imgpsn">
        <form action="saveimage" enctype="multipart/form-data" method="post">

            <div class="hinhanh">
            <img class="imgchile" src="uploads/${usermodel.namefileimage} ">
                <div class="plus">
                    <i class="ti-settings white"></i>
                </div>
                <input type="file" id="myFile" name="filename" value="chọn ảnh">
            </div>

            <input class="qhuy" type="submit" value="lưu thay đổi">

        </form>




        <h4 id="text">${nameuser}</h4>
    </div>

    <div class="menu">
        <ul>
            <li>
                <form action="loader">
                    <span class="snote">seach note  <button type="submit" ><i class="ti-search" ></i></button> </span><input class="sch" type="text" name="seachnote" value="<%= (String)session.getAttribute("infnote")%>">

                </form>

            </li>
            <li> <a href="#"><i class="ti-user"></i></a> <span class="sp">Account</span>  </li>
            <li> <a href="login.jsp"><i class="ti-shift-right"></i></a>  <span class="sp">Logout</span>  </li>
        </ul>
    </div>
    <img class="addimg" src="./img/pixlr-bg-result.jpg">
    <img class="addimg" src="./img/socket.png">
</div>

<div class="content" id="ct">
    <% int i=0; %>
    <c:forEach items="${Listnote.listmodel}" var="x">
<% ++i;
        %>

        <div class="note"id="<%= i%>">
            <div class="manct ">
                <p class="edited">${x.edittime}</p>
                <h2 class="get">${x.notename}</h2>
                <p class="timeago"> ${x.time}<p>
                <p class="get1">${x.content}</p>
                <a class="cha"  > <button class="decor"> View</button> </a>
                <a class="edit" onclick="addclass(<%=i %>)" title="Edit" data-toggle="tooltip" > <button class="decor">Edit</button> </a>
                <a class="cha1" href="#" onclick="alertmethod(${x.idnote},${Listnote.page},<%=i%>)"> <button class="delete decor"> Delete</button> </a>
                <a class="cancel1" onclick="cancelclick(${x.idnote},<%= i%>, ${Listnote.page})"><button class="decor">cancel</button></a>
                <a class="oke"  onclick="editmethod(${x.idnote},<%= i%>, ${Listnote.page})"><button class="decor">oke</button></a>
            </div>
        </div>
    </c:forEach>




        <ul class="pagination pos" id="pagination" aria-disabled="true"></ul>

</div>


<input type="hidden" value="ka" id="page" name="page1">
<input type="hidden" value="" id="maxpage" name="maxpageitem">


<div class="for">
    <div class="chile">

        <form id="insertsubmit" action="insert" method="post">
            <div class="modal-header">
                <h4 id="table_alert" class="modal-title">Thêm note</h4>
                <div class="butclose">
                    <i class="ti-close"></i>
                </div>

            </div>
            <div class="modal-body">

                <p>chủ đề </p>
                <input type="text" class="form-control" id="chude" name="insertnotef" value="" required readonly="">
                <p>nội dung </p>
                <textarea name="insertcontentf" id="noidung" readonly="" ></textarea>




            </div>
            <div class="modal-footer">
                <input type="button"  class="btn btn-default" onclick="cancelinsert()" data-dismiss="modal" value="Cancel" readonly="">
                <input type="button" onclick="passinsert()" id="savebtn" class="btn btn-info" value="Save" readonly="">
            </div>
        </form>
    </div>
</div>

<a  class="insertcl">
    <div class="add">
        <i class="ti-plus"></i>
    </div>
</a></body>



<script type="text/javascript">


    var test;
    var insert;
    var view;
    var check=1;
    check =2;
    var savebtn =document.getElementById("savebtn")
    var in1 = document.querySelector('.insertcl');
    var un2 = document.querySelector('.for');
    var in3 = document.querySelector('.butclose');
    var in4 =document.querySelector('.modal-body .form-control');
    var areat=    document.querySelector('.modal-body textarea');

function  passinsert(){

    if( !$('#chude').val()){
   $('#chude').addClass("error");
    }
    else {

         document.getElementById('insertsubmit').submit();
        $('#chude').removeClass("error");

    }
}

    $(document).on("click",".cha",function (){
        $('#table_alert').text(" chế độ xem ");
        un2.style.animation=`tele ease .4s,fadeOut linear 1s 3s forwards`;
        savebtn.classList.add('off');
        un2.classList.toggle('apear');
        $(this).parent(".manct").find(".get").each(function(){
            in4.value = $(this).text();

            $('#chude').attr("readonly",true);
        });
        $(this).parent(".manct").find(".get1").each(function(){
            areat.value= $(this).text();
            $('#noidung').attr("readonly",true);
        });
    })

    in1.onclick =function(){
        $('#table_alert').text(" thêm note ");
        $('#chude').attr("readonly",false);
        $('#noidung').attr("readonly",false);
        savebtn.classList.remove('off');
        un2.classList.toggle('apear');


    }
    in3.onclick =function(){

        un2.classList.toggle('apear');
        in4.value ='';
        areat.value='';
        $('#chude').removeClass("error");



    }
  function addclass(i){
        var addclss = document.getElementById(i);

        addclss.classList.add('danhdauedit');
  }

    function cancelinsert(page){

        un2.classList.toggle('apear');
        in4.value ='';
        areat.value='';
        $('#chude').removeClass("error");


    }
    function cancelclick(idnote,i,page){
        var item =  document.getElementById(i);
        $.ajax({
            url:"cancledit",
            type:"get",
            data: {

                idnote:idnote,
                id:i,
                page:page,

            },
            success: function (respose){
             var  thongbao = confirm(" bạn chắc có muốn hủy !");
             if(thongbao===true){



                 var elmt =document.createElement("div");
                elmt.innerHTML += respose;
                item.replaceWith(elmt);}




            },
            error: function (xhr){
                alert("adaw");
            }
        })
    }
 function editmethod(idnote,i,page){


     var notename = $(document).find("#"+i+" .title").val();
     var content = $(document).find("#"+i+" .content").val();
     var item =  document.getElementById(i);
     if( !$(document).find("#"+i+" .title").val()){
         $(document).find("#"+i+" .title").addClass("error");


     }
     else {
         var addclss = document.getElementById(i);
         addclss.classList.add('around');

         $(document).find("#"+i+" .title").remove("error");
         $.ajax({
             url: "update",
             type: "get",
             data: {

                 idnote: idnote,
                 notename: notename,
                 content: content,
                 id: i,
                 page: page,

             },
             success: function (respose) {

                 var elmt = document.createElement("div");
                 elmt.innerHTML += respose;
                 item.replaceWith(elmt);


             },
             error: function (xhr) {

                 alert("adaw");
             }
         })
     }
 }
    $(document).on("click",".edit",function (){
        $(this).parent(".manct").find(".get").each(function (){

            $(this).html('<input type="text" class="title" name="notename" value="'+$(this).text() +'" required >');
        });
        $(this).parent(".manct").find(".get1").each(function (){

            $(this).html('<textarea name="content" class="content" cols="37" rows="4"> '+ $(this).text() +'</textarea>');
        });
        $(this).parent(".manct").find(".edited").each(function (){

           $(this).addClass("off");
        });
        $(this).parent(".manct").find(".cha").each(function (){
            $(this).html('');
        });
        $(this).parents(".manct").find(".cancel1,.delete").toggle();
        $(this).parents(".manct").find(".oke,.edit").toggle();
    });

    $(function () {
        var totalpage = ${Listnote.totalpage};
        var currentpage =${Listnote.page};
        var limit =3;
        window.pagObj = $('#pagination').twbsPagination({
            totalPages:  ${Listnote.totalpage},
            visiblePages:3,
            startPage : ${Listnote.page},
            onPageClick: function (event, page) {

                if(currentpage !=page)
                {



                        window.location.href = 'loader?page=' + page;

                }


            }
        })
    });





    var gg = document.querySelectorAll('.note');

    function alertmethod(idnote,page,i){

        var option = confirm('bạn chắc chắn muốn xóa ?')
        if(option === true){


            var idclass = document.getElementById(i);
           var number = document.getElementsByClassName("note").length-1;
           $.ajax({
               url:"delete",
               type:"get",
               data: {
                   num : number,
                   idnote:idnote,
                   page:page

               },
               success: function (respose){
                   var index =page;
                   if(<%=i %>-1===0){
                       index = index-1;
                   }
                   window.location.href = 'loader?page=' + index;


               },
           })
        }

    }


</script>
</html>



