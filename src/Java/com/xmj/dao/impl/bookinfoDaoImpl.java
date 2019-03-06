package com.xmj.dao.impl;

import com.xmj.dao.bookinfoDao;
import com.xmj.vo.bookinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class bookinfoDaoImpl implements bookinfoDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public bookinfoDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addbookinfo(String cus_id, String com_code, String fli_no, String boo_baddress, String boo_aaddress, String boo_btime, String boo_atime, String boo_berth, String boo_number, String boo_fare)
            throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String boo_time = (String) (df.format(new Date()));

        try {
            String sql = "insert into bookinformation (com_code,cus_id,boo_everyday,boo_no,boo_baddress,boo_aaddress," +
                    "boo_btime,boo_atime,boo_berth,boo_number,boo_fare,boo_time,flag_pay,flag_type,flag_pass)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, com_code);
            this.pstmt.setString(2, cus_id);
            this.pstmt.setString(3, "0");
            this.pstmt.setString(4, fli_no);
            this.pstmt.setString(5, boo_baddress);
            this.pstmt.setString(6, boo_aaddress);
            this.pstmt.setString(7, boo_btime);
            this.pstmt.setString(8, boo_atime);
            this.pstmt.setString(9, boo_berth);
            this.pstmt.setString(10, boo_number);
            this.pstmt.setString(11, boo_fare);
            this.pstmt.setString(12, boo_time);
            this.pstmt.setString(13, "0");
            this.pstmt.setString(14, "1");
            this.pstmt.setString(15, "0");
            this.pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();

                } catch (Exception e) {
                    throw e;
                }
            }
        }


    }

    @Override
    public List<bookinfo> findNoPay(String cus_id, String  flag_pay) throws Exception {
        List<bookinfo> list = new ArrayList<>();

        try{
            String sql = "select * from bookinformation where cus_id =? and flag_pay =? and flag_pass='0'";
            this.pstmt =this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_id);
            this.pstmt.setString (2,flag_pay);
            ResultSet rs  = this.pstmt.executeQuery();
            while(rs.next()){
                bookinfo bookInfo = new bookinfo();
                bookInfo.setBoo_autoid(rs.getInt("boo_autoid"));
                bookInfo.setCom_code(rs.getString("com_code"));
                bookInfo.setCus_id(rs.getString("cus_id"));
                bookInfo.setBoo_everyday(rs.getString("boo_everyday"));
                bookInfo.setBoo_no(rs.getString("boo_no"));
                bookInfo.setBoo_baddress(rs.getString("boo_baddress"));
                bookInfo.setBoo_aaddress(rs.getString("boo_aaddress"));
                bookInfo.setBoo_btime(rs.getString("boo_btime"));
                bookInfo.setBoo_atime(rs.getString("boo_atime"));
                bookInfo.setBoo_berth(rs.getString("boo_berth"));
                bookInfo.setBoo_number(rs.getInt("boo_number"));
                bookInfo.setBoo_fare(rs.getFloat("boo_fare"));
                bookInfo.setBoo_time(rs.getString("boo_time"));
                list.add(bookInfo);

            }
        }catch(Exception e){
            throw e;
        }finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }

        return list;
    }

    @Override
    public void updateflag_pass(String cus_id, String boo_time) throws Exception {
        try{
            String sql = "update bookinformation set flag_pass = '1' where cus_id =? and boo_time = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_id);
            this.pstmt.setString(2,boo_time);
            this.pstmt.executeUpdate();
        }catch(Exception e )
        {
            throw  e;
        }finally {
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e ){
                    throw  e;
                }
            }
        }
    }

    @Override
    public int findBoo_autoid(String cus_id, String boo_time) throws Exception {

        int boo_autoid = 0;

        try{
           String sql = "select boo_autoid from bookinformation where cus_id = ? and boo_time = ?";
           this.pstmt = this.conn.prepareStatement(sql);
           this.pstmt.setString(1,cus_id);
           this.pstmt.setString(2,boo_time);
           ResultSet rs = this.pstmt.executeQuery();
           if(rs.next()){
               boo_autoid = rs.getInt("boo_autoid");
           }
       }catch ( Exception e){
           throw  e;
       }finally {
           if(this.pstmt!=null){
               try{
                   this.pstmt.close();
               }catch (Exception e){
                   throw e ;
               }
           }
       }
       return boo_autoid;
    }
}
