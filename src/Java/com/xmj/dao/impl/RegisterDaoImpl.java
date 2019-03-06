package com.xmj.dao.impl;

import com.xmj.CusInfoServlet;
import com.xmj.dao.RegisterDao;
import com.xmj.vo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class RegisterDaoImpl implements RegisterDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public RegisterDaoImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public void addCustomer(Customer customer) throws Exception {


        try{
            String sql = "insert into customer(cus_account,cus_pwd,cus_id,cus_sex,cus_telnumber,cus_email,cus_time,cus_integral,flag) values(?,?,?,?,?,?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);

            this.pstmt.setString(1,customer.getCus_account());
            this.pstmt.setString(2,customer.getCus_pwd());
            this.pstmt.setString(3,customer.getCus_id());
            this.pstmt.setString(4,customer.getCus_sex());
            this.pstmt.setString(5,customer.getCus_telnumber());
            this.pstmt.setString(6,customer.getCus_email());
            this.pstmt.setString (7,"2018-12-14");
            this.pstmt.setString(8,"0");
            this.pstmt.setString(9,"1");
            this.pstmt.executeUpdate();

        }catch(Exception e ){
            throw e ;

        }finally{
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
    public Customer findCustomer(String cus_account ) throws Exception {
        boolean flag= false;
        Customer cus = new Customer();
        try{
            String sql="select  * from customer where cus_account = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,cus_account);
            ResultSet rs = this.pstmt.executeQuery();

            if(rs.next()){
                cus.setCus_account(rs.getString (2));
                cus.setCus_pwd(rs.getString("cus_pwd"));
                cus.setCus_id(rs.getString("cus_id"));
                cus.setCus_telnumber(rs.getString("cus_telnumber"));
                cus.setCus_email(rs.getString("cus_email"));
                cus.setCus_integral(rs.getInt("cus_integral"));
                flag= true;
            }
        }catch(Exception e){
            throw e;
        }finally{
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e ){
                    throw e;
                }
            }
        }
        return cus;
    }

    @Override
    public void updatePwd(String newcus_account) throws Exception {
        try{
            String sql = "update customer set cus_pwd=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,newcus_account);
             this.pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(this.pstmt!=null){
                try{
                    this.pstmt.close();
                }catch(Exception e ){
                    throw e;
                }
            }
        }
    }
}
