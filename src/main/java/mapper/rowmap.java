package mapper;

import java.sql.ResultSet;

public interface rowmap<T> {
    T mapfindall(ResultSet rs);

}
