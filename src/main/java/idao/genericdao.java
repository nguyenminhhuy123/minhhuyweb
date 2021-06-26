package idao;

import mapper.rowmap;

import java.util.List;

public interface genericdao<T> {
    List<T> query(String sql,rowmap<T> rowmap,Object... parameters);

}
