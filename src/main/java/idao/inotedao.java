package idao;

import model.notemodel;
import model.usermodel;

import java.util.List;

public interface inotedao {
 List<notemodel> getnotebyuserid(Object... parametters);
 void delete(Object... parameters);
  void insertnote(Object... parameters);
  List<notemodel> getnotebyid(Object... parameters);
  void updatenote(Object... parameters);
  List<notemodel> seachnoteautomactic(Object... parameters);
 List<notemodel> gettop3(Object... parametters);
 List<notemodel> getnextnote(Object... parametters);
 void saveimage(Object... parametters);


}
