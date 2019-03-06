package com.xmj.dao.impl;

import com.xmj.dao.fli_infoDao;
import com.xmj.vo.fli_info;
import com.xmj.vo.flightinfomation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class fli_infoDaoImpl implements fli_infoDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public fli_infoDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<fli_info> findFli_info(String fli_baddress, String fli_aaddress, String fli_btime,String fli_number,String fli_fare) throws Exception {

        List<fli_info> list = new ArrayList<>();
        try {
            String sql = "select * from flightinformation a inner join flightcompany b on a.com_code = b.com_code where fli_baddress=? and fli_aaddress =? and fli_btime like ?";

            this.pstmt = this.conn.prepareStatement(sql);

            this.pstmt.setString(1,fli_baddress );
            this.pstmt.setString(2,fli_aaddress);
            this.pstmt.setString(3,"%"+fli_btime+"%");

            ResultSet rs = this.pstmt.executeQuery();

            while(rs.next()) {
                fli_info fli_Info = new fli_info();




                fli_Info.setCom_code(rs.getString("com_code"));
                fli_Info.setCom_name(rs.getString("com_name"));
                fli_Info.setFli_btime(rs.getString("fli_btime"));
                fli_Info.setFli_atime(rs.getString("fli_atime"));
                fli_Info.setAir_code(rs.getString("air_code"));
                fli_Info.setFli_no(rs.getString("fli_no"));

                fli_Info.setFli_number(rs.getInt(fli_number));
                fli_Info.setFli_fare(rs.getFloat(fli_fare));
                list.add(fli_Info);
            }
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

        return list;
    }

    @Override
    public fli_info findFli_info2(String fli_no)throws Exception {
       fli_info fli_Info = new fli_info();
        try{
            String sql ="select * from flightinformation where fli_no = ?";
            this.pstmt = this.conn.prepareStatement(sql);

            this.pstmt.setString(1,fli_no);
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){
                fli_Info.setFli_no(rs.getString("fli_no"));
                fli_Info.setCom_code(rs.getString("com_code"));
                fli_Info.setFli_btime(rs.getString("fli_btime"));
                fli_Info.setFli_atime(rs.getString("fli_atime"));


            }
        }catch (Exception e ){
            throw  e;
        }finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return fli_Info;
    }

    @Override
    public void updateflag_pay(String cus_id, String boo_time) throws Exception {

        try{
            String sql ="update bookinformation set flag_pay='1' where cus_id=? and boo_time = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_id);
            this.pstmt.setString(2,boo_time);
            this.pstmt.executeUpdate();
        }catch(Exception e ){
            throw e ;
        }finally{
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e ){
                     throw e ;
                }
            }
        }
    }

    @Override
    public void updateFli_info(flightinfomation flightinfo) throws Exception {
        try{
            String sql = "update flightinformation set fli_Ffare=? ,  fli_Cfare=? ,  fli_Yfare=? ,  fli_refundtime=? where fli_no=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setFloat(1,flightinfo.getFli_Ffare());
            this.pstmt.setFloat(2,flightinfo.getFli_Cfare());
            this.pstmt.setFloat(3,flightinfo.getFli_Yfare());
            this.pstmt.setString(4,flightinfo.getFli_refundtime());
            this.pstmt.setString(5,flightinfo.getFli_no());
            this.pstmt.executeUpdate();
        }catch (Exception e ){
            throw e;
        }finally{
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e){
                    throw e ;
                }
            }
        }
    }

    @Override
    public void addFli_info(flightinfomation flightinfo) throws Exception {
        try{
            String sql = "insert into flightinformation(com_code,air_code,fli_everyday," +
                    "fli_no,fli_discount,fli_baddress,fli_aaddress,fli_btime,fli_atime,fli_Fnumber," +
                    "fli_Cnumber,fli_Ynumber,fli_Ffare,fli_Cfare,fli_Yfare,fli_refundtime,fli_refund,flag) values(?,?,?,?," +
                    "?,?,?,?," +
                    "?,?,?,?," +
                    "?,?,?,?," +
                    "?,?)";
            this.pstmt = this.conn .prepareStatement(sql);
            this.pstmt.setString(1,flightinfo.getCom_code());
            this.pstmt.setString(2,flightinfo.getAir_code());
            this.pstmt.setString(3,flightinfo.getFli_everyday());
            this.pstmt.setString(4,flightinfo.getFli_no());
            this.pstmt.setFloat(5,flightinfo.getFli_dicount());
            this.pstmt.setString(6,flightinfo.getFli_baddress());
            this.pstmt.setString(7,flightinfo.getFli_aaddress());
            this.pstmt.setString(8,flightinfo.getFli_btime());
            this.pstmt.setString(9,flightinfo.getFli_atime());
            this.pstmt.setInt(10,flightinfo.getFli_Fnumber());
            this.pstmt.setInt(11,flightinfo.getFli_Cnumber());
            this.pstmt.setInt(12,flightinfo.getFli_Ynumber());
            this.pstmt.setFloat(13,flightinfo.getFli_Ffare());
            this.pstmt.setFloat(14,flightinfo.getFli_Cfare());
            this.pstmt.setFloat(15,flightinfo.getFli_Yfare());
            this.pstmt.setString(16,flightinfo.getFli_refundtime());
            this.pstmt.setBoolean(17,flightinfo.isFli_refund());
            this.pstmt.setBoolean(18,flightinfo.isFlag());
            this.pstmt.executeUpdate();
        }catch(Exception e){
            throw e ;
        }finally {
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e ){
                    throw e;
                }
            }
        }
    }

    @Override
    public List<flightinfomation> findFli_info(String fli_no) throws Exception {

        List<flightinfomation> list = new ArrayList<>();
        try {
            String sql = "select * from flightinformation where fli_no = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, fli_no);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                flightinfomation flightinfo = new flightinfomation();
                flightinfo.setCom_code(rs.getString("com_code"));
                flightinfo.setAir_code(rs.getString("air_code"));

                flightinfo.setFli_no(rs.getString("fli_no"));

                flightinfo.setFli_baddress(rs.getString("fli_baddress"));
                flightinfo.setFli_aaddress(rs.getString("fli_aaddress"));
                flightinfo.setFli_btime(rs.getString("fli_btime"));
                flightinfo.setFli_atime(rs.getString("fli_atime"));
                flightinfo.setFli_Fnumber(rs.getInt("fli_Fnumber"));
                flightinfo.setFli_Cnumber(rs.getInt("fli_Cnumber"));
                flightinfo.setFli_Ynumber(rs.getInt("fli_Ynumber"));
                flightinfo.setFli_Ffare(rs.getFloat("fli_Ffare"));
                flightinfo.setFli_Cfare(rs.getFloat("fli_Cfare"));
                flightinfo.setFli_Yfare(rs.getFloat("fli_Yfare"));
                flightinfo.setFli_refundtime(rs.getString("fli_refundtime"));
                flightinfo.setFli_refund(rs.getBoolean("fli_refund"));
                list.add(flightinfo);
            }
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
        return  list;
    }

    @Override
    public void updateFli_refund(String fli_no ,boolean fli_refund) throws Exception {
        try{
            String sql = "update flightinformation set fli_refund = ? where fli_no= ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setBoolean(1,fli_refund);
            this.pstmt.setString(2,fli_no);
            this.pstmt.executeUpdate();
        }catch (Exception e){
            throw e ;
        }finally {
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch (Exception e ){
                    throw e;
                }
            }
        }
    }
}


