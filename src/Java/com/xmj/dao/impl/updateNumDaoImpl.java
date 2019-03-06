package com.xmj.dao.impl;

import com.xmj.dao.updateNumDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class updateNumDaoImpl implements updateNumDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public updateNumDaoImpl(Connection conn ){
        this.conn = conn;
    }

    @Override
    public void updateNum(String boo_berth,String boo_no,String flag) throws Exception {
     String fli_number;

     String change;
      if(boo_berth.equals("头等舱")){
          fli_number = "fli_Fnumber";
      }else if(boo_berth.equals("公务舱")){
          fli_number = "fli_Cnumber";
      }else {
          fli_number = "fli_Ynumber";
      }
      if(flag=="refund"){
          change = "+1";
      }else{
          change = "-1";
      }

      try{

          String sql ="update flightinformation set "+fli_number+ "="+ fli_number+change+" where fli_no =?";
          this.pstmt = this.conn.prepareStatement(sql);
          this.pstmt.setString(1,boo_no);

          this.pstmt.executeUpdate();
      }catch(Exception e ){
          e.printStackTrace();
      }finally {
          if(this.pstmt!=null){
              try{
                  this.pstmt.close();
              }catch (Exception e){
                  throw e;
              }
          }
      }
    }
}
