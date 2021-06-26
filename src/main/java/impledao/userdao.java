package impledao;

import abstracts.abstracts;
import idao.iuserdao;
import mapper.mapfinduser;
import model.usermodel;

import java.util.List;

public class userdao extends abstracts<usermodel> implements iuserdao {
    @Override
    public List<usermodel> getuserbyuseridandpass(Object... parametters) {
        String sql = "select * from user where iduser=? and passwd =?";
        return query(sql,new mapfinduser(),parametters);
    }

    @Override
    public void insertuser(Object... parameters) {
        String sql ="INSERT INTO user (iduser, passwd)\n" +
                "VALUES (?,?);";
        updatequery(sql,parameters);
    }

    @Override
    public List<usermodel> getuserbyuserid(Object... parametters) {
        String sql = "select * from user where iduser=?";
        return query(sql,new mapfinduser(),parametters);
    }

    @Override
    public void updatepassword_byiduser(Object... parametters) {
        String sql ="UPDATE user\n" +
                "SET passwd =?\n" +
                "WHERE iduser =?;";
         updatequery(sql,parametters);
    }

    @Override
    public List<usermodel> checkpassword(Object... parametters) {
         String sql = "select * from user where passwd = ?";
         return query(sql,new mapfinduser(),parametters);
    }
    public void insertimage(Object... parametters) {
        String sql = "update user set  image= ?,  filenameimage =? where iduser =?";
        updatequery(sql,parametters);
    }
    public List<usermodel> getimage(Object... parametters){
        String sql ="select * from user where iduser =?";

        return query(sql,new mapfinduser(), parametters);
    }

}
