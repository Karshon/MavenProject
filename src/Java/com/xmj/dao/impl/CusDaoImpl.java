package com.xmj.dao.impl;

import com.xmj.dao.CusDao;
import com.xmj.vo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CusDaoImpl implements CusDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public CusDaoImpl(Connection conn ){
        this.conn = conn;
    }


    @Override
    public boolean findLogin(Customer cus) throws Exception {
        boolean flag = false;
        try{
            String sql = "Select * from customer where cus_account =? and cus_pwd = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus.getCus_account());
            this.pstmt.setString(2,cus.getCus_pwd());
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){
                cus.setCus_account(rs.getString(2));
                flag= true;
            }
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
        return flag;

    }

    @Override
    public Customer findCustomer(String cus_account) throws Exception {
        Customer customer = new Customer();
        try{
            String sql= "select * from customer where cus_account= ? and flag =1";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_account);
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){
                customer.setCus_account(rs.getString("cus_account"));
               customer.setCus_id(rs.getString("cus_id"));
               customer.setCus_sex(rs.getString("cus_sex"));
               customer.setCus_telnumber(rs.getString("cus_telnumber"));
               customer.setCus_email(rs.getString("cus_email"));
               customer.setCus_time(rs.getString("cus_time"));
               customer.setCus_integral(rs.getInt("cus_integral"));
               customer.setFlag(rs.getBoolean("flag"));
            }
        }catch (Exception e){
            throw e ;
        }finally{
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch (Exception e){
                    throw e ;
                }
            }
        }
        return customer;
    }

    @Override
    public String findCus_id(String cus_account) throws Exception {
        String cus_id=null;
        try{
            String sql = "select cus_id from customer where cus_account = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_account);
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){
                cus_id = rs.getString("cus_id");
            }
        }catch(Exception e ){
            throw e;
        }finally{
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e ){
                    throw e ;
                }
            }
        }
        return cus_id;
    }

    @Override
    public void updateCus_integral(String cus_id,String  flag ) throws Exception {
        String  change = null;
        if(flag=="add"){
             change = "+2";
        }else if(flag=="refund"){
            change = "-5";
        }
        try{
            String sql = "update customer set cus_integral = cus_integral"+change+" where cus_id = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_id);
            this.pstmt.executeUpdate();
        }catch (Exception e ){
            throw e ;
        }finally{
            if(this.pstmt!=null){
                try{
                  this.pstmt.close();
                }catch (Exception e){
                    throw e;
                }
            }
        }
    }

    @Override
    public void deleteCus(String cus_account) throws Exception {
        try{
            String sql = "update customer set flag = 0 where cus_account = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_account);
            this.pstmt.executeUpdate();
        }catch (Exception e){
            throw e ;
        }finally{
                if(this.pstmt!=null){
                    try{
                        this.pstmt.close();
                    }catch (Exception e){
                        throw e ;
                    }
                }
    }
    }

    @Override
    public void updateCus(String cus_telnumber,String cus_email,String cus_account) throws Exception {

        try{
            String sql = "update customer set cus_telnumber = ?,cus_email =? where cus_account=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_telnumber);
            this.pstmt.setString(2,cus_email);
            this.pstmt.setString(3,cus_account);
            this.pstmt.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
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
