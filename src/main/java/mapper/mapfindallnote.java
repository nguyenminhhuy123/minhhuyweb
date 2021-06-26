package mapper;

import model.notemodel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mapfindallnote implements  rowmap<notemodel>{

    @Override
    public notemodel mapfindall(ResultSet rs) {
        notemodel note = new notemodel();
        try {

            note.setIdnote(rs.getInt("idnote"));
            note.setIduser(rs.getString("iduser"));
            note.setContent(rs.getString("content"));
            note.setNotename(rs.getString("notename"));
            note.setCreatedatetime(rs.getTimestamp("createdatetime"));
            note.setEditdatetime(rs.getTimestamp("editday"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

       return note;
    }
}
