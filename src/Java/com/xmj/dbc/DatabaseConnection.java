package com.xmj.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static  final String DBDRIVER="com.mysql.jdbc.Driver";
    private  static  final String DBURL ="jdbc:mysql://localhost:3306/flightbooksystem";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "123456";
    private Connection conn = null;
    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        }catch(Exception e ){
            throw e ;
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void close() throws SQLException {
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch(Exception e ){
                throw e;
            }
        }
    }



}
