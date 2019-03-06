package com.xmj.dao.impl;

import com.xmj.dao.ManagerDao;
import com.xmj.dbc.DatabaseConnection;
import com.xmj.vo.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDaoImpl implements ManagerDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public ManagerDaoImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public Manager findManager(String man_account,String man_pwd)throws Exception {
        Manager manager = new Manager();

        try{
            String sql = "select * from manager where man_account = ? and man_pwd =?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,man_account );
            this.pstmt.setString(2,man_pwd);
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){

                manager.setMan_account(rs.getString("man_account"));
                manager.setMan_pwd(rs.getString("man_pwd"));
                manager.setMan_id(rs.getString("man_id"));
                manager.setMan_sex(rs.getString("man_sex"));
                manager.setMan_telnumber(rs.getString("man_telnumber"));
                manager.setMan_email(rs.getString("man_email"));
                manager.setMan_time(rs.getDate("man_time"));
            }

        }catch (Exception e){
            throw e ;
        }finally {
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch (Exception e ){
                    throw e ;
                }
            }
        }

        return manager;
    }
}
