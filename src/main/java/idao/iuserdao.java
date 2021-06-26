package idao;

import model.usermodel;

import java.util.List;

public interface iuserdao {
    List<usermodel> getuserbyuseridandpass(Object... parametters);
    void insertuser(Object... parameters);
     List<usermodel> getuserbyuserid(Object... parametters);
     void updatepassword_byiduser(Object... parametters);
     List<usermodel> checkpassword(Object... parametters);
    void insertimage(Object... parametters);
    List<usermodel> getimage(Object... parametters);

}