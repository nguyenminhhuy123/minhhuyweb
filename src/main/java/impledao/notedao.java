package impledao;

import abstracts.abstracts;
import idao.inotedao;
import mapper.mapfindallnote;
import mapper.mapfinduser;
import model.notemodel;
import model.usermodel;

import java.util.ArrayList;
import java.util.List;

public class notedao extends abstracts<notemodel> implements inotedao {

        @Override
        public void saveimage(Object... parametters){
          String sql ="UPDATE user\n" +
                  "SET image=?,filenameimage=? \n" +
                  "WHERE iduser=?;";
          updatequery(sql,parametters);
        }
        public List<notemodel> getnotebyuserid(Object... parametters) {
            List<notemodel> list;
            String sql = "select * from note where notename like ? and  iduser = ? ";
            if( query(sql,new mapfindallnote(),parametters).size()==0){
                String sql1 = "select * from note where content like ? and iduser =?";
                list = query(sql1,new mapfindallnote(),parametters);
            }
            else {
                list = query(sql,new mapfindallnote(),parametters);
            }

            return list;
        }
        @Override
        public void insertnote(Object... parameters){
                    String sql ="insert into note (iduser,content,notename,createdatetime) values(?,?,?,?)";
                  updatequery(sql,parameters);
            }
        @Override
        public void delete(Object... parameters){
            String sql = " delete  from note where idnote = ?";
             updatequery(sql,parameters);
            }
         @Override
          public List<notemodel> getnotebyid(Object... parameters){

                String sql ="select * from  note where idnote =? order by createdatetime desc";
                return query(sql,new mapfindallnote(),parameters);
            }
         @Override
         public void updatenote(Object... parameters){

            String sql ="UPDATE note\n" +
                    "SET content = ?, notename= ? , editday =?\n " +
                    "WHERE idnote = ?;";
             updatequery(sql,parameters);
            }
          @Override
         public List<notemodel> seachnoteautomactic(Object... parameters){
            List<notemodel> list ;
            String sql ="select  * from note \n" +
                    " where notename like  ? and iduser = ?\n" +
                    " ORDER BY createdatetime desc\n" +
                    " limit 6\n" +
                    " offset ?;\n";
            if(query(sql,new mapfindallnote(),parameters).size()==0){
                String sql1 ="select  * from note \n" +
                        " where content like  ? and iduser = ?\n" +
                        " ORDER BY createdatetime desc\n" +
                        " limit 6\n" +
                        " offset ?;\n";
                list =query(sql1,new mapfindallnote(),parameters);
            }
            else {
                list =query(sql,new mapfindallnote(),parameters);
            }
            return list;
         }
    public List<notemodel> gettop3(Object... parametters){
        String sql=" select  * from note \n" +
                " where iduser =?\n" +
                " order by createdatetime desc\n" +
                " limit ? ";
        return query(sql,new mapfindallnote(),parametters);
    }
    public List<notemodel> getnextnote(Object... parametters){
        String sql=" SELECT *\n" +
                "FROM note \n" +
                "where iduser=?\n" +
                "ORDER BY createdatetime desc\n" +
                "LIMIT 6\n" +
                "OFFSET ?;\n ";
        return query(sql,new mapfindallnote(),parametters);
    }


    }


