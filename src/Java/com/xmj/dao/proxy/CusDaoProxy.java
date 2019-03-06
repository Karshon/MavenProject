package com.xmj.dao.proxy;

import com.xmj.dao.CusDao;
import com.xmj.dao.impl.CusDaoImpl;
import com.xmj.vo.Customer;
import com.xmj.dbc.DatabaseConnection;

public class CusDaoProxy implements CusDao {
    private DatabaseConnection dbc = null;
    private CusDao dao = null;
    public CusDaoProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch (Exception e ){
            e.printStackTrace();
        }
        this.dao  = new CusDaoImpl(this.dbc.getConnection());
    }

    @Override
    public boolean findLogin(Customer cus) throws Exception {
        boolean flag = false;
        try{
            flag = this.dao.findLogin(cus);
        }catch(Exception e ){
            throw e ;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public Customer findCustomer(String cus_account) throws Exception {
        Customer customer = new Customer();
        try{
            customer = this.dao.findCustomer(cus_account);
        }catch (Exception e){
            throw e ;
        }finally {
            this.dbc.close();
        }
        return customer;
    }

    @Override
    public String findCus_id(String cus_account) throws Exception {
        String cus_id = null;
        try{
            cus_id = this.dao.findCus_id(cus_account);
        }catch (Exception e){
            throw e ;
        }finally{
            this.dbc.close();
        }
        return cus_id;
    }

    @Override
    public void updateCus_integral(String cus_id,String flag ) throws Exception {
        try{
            this.dao.updateCus_integral(cus_id, flag);
        }catch(Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public void deleteCus(String cus_account) throws Exception {
        try{
            this.dao.deleteCus(cus_account);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

    @Override
    public void updateCus(String cus_telnumber, String cus_email, String cus_account) throws Exception {
        try{
            this.dao.updateCus(cus_telnumber,cus_email,cus_account);
        }catch (Exception e){
            throw e ;
        }finally{
            this.dbc.close();
        }
    }
}
