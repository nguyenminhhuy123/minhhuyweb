package mapper;

import model.notemodel;
import model.usermodel;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  mapfinduser implements rowmap<usermodel>{
    @Override
    public usermodel mapfindall(ResultSet rs) {
        usermodel usermodel = new usermodel();
        try {

            usermodel.setPassword(rs.getString("passwd"));
            usermodel.setIduser(rs.getString("iduser"));



            usermodel.setNamefileimage(rs.getString("filenameimage"));

            Blob file = rs.getBlob("image");
            if (file!=null) {
                usermodel.setImage(file.getBytes(1, (int) file.length()));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return usermodel;
    }
}
