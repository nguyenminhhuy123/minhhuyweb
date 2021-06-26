package abstracts;

import idao.genericdao;
import mapper.rowmap;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class abstracts<T>  {
    public Connection getconnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/datanotepad";
            String user = "root";
            String password = "0701200119cnttc";

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {

            return null;

        }
    }
    public List<T> query(String sql,rowmap<T> rowmap,Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = getconnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                setdata(statement,parameters);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   results.add(rowmap.mapfindall(resultSet));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    if(connection !=null){
                        connection.close();
                    }
                    if(statement !=null){
                        statement.close();
                    }
                    if(resultSet !=null){
                        resultSet.close();
                    }

                } catch (SQLException throwables) {



                }
            }
        }
        return results;
    }
    public void updatequery(String sql,Object... parameters){
        Connection connection =getconnection();
        PreparedStatement statement =null;
        if(connection !=null){
            try {

                statement =connection.prepareStatement(sql);
                setdata(statement,parameters);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    if(connection !=null){
                        connection.close();
                    }
                    if(statement !=null){
                        statement.close();
                    }


                } catch (SQLException throwables) {
                }
            }
        }

    }

    private void setdata(PreparedStatement statement ,Object... parameters) {
        try {
            for (int i =0;i< parameters.length;i++){
                Object t =parameters[i];
                int index =i+1;
                if(t instanceof Integer){
                    statement.setInt(index, (Integer)parameters[i]);
                }
                else if(t instanceof String){
                    statement.setString(index,(String) parameters[i]);
                }
                else if(t instanceof Timestamp){
                    statement.setTimestamp(index, (Timestamp) parameters[i]);
                }
                else if(t instanceof FileInputStream){
                    statement.setBinaryStream(index,(FileInputStream) parameters[i]);
                }

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        }

}