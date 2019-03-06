package com.xmj.dao.impl;

import com.xmj.dao.refundrecordDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class refundrecordDaoImpl implements refundrecordDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public refundrecordDaoImpl(Connection conn){this.conn = conn;}
    @Override
    public void addrefundrecord(int boo_autoid, String boo_number)throws Exception {

        try{
            String sql = "insert into refundrecord (boo_autoid,boo_number) values(?,?);";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1,boo_autoid);
            this.pstmt.setString(2,boo_number);
            this.pstmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally {
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch (Exception e){
                    throw e ;
                }
            }
        }
    }
}
