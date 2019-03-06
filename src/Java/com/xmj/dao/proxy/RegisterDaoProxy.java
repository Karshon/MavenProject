package com.xmj.dao.proxy;

import com.xmj.dao.RegisterDao;
import com.xmj.dao.impl.RegisterDaoImpl;
import com.xmj.vo.Customer;
import com.xmj.dbc.DatabaseConnection;
public class RegisterDaoProxy implements RegisterDao {
    private DatabaseConnection dbc = null;
    private RegisterDao dao = null;
    public RegisterDaoProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
        this.dao= new RegisterDaoImpl(this.dbc.getConnection());
    }
    @Override
    public void addCustomer(Customer customer) throws Exception {

        try{
           this.dao.addCustomer(customer);

        }catch(Exception e ){
            throw e;
        }finally{
            this.dbc.close();
        }

    }

    @Override
    public Customer  findCustomer(String cus_account) throws Exception {
        Customer cus;
        try{
            cus = this.dao.findCustomer(cus_account);

        }catch(Exception e ){
            throw e;
        }finally{
            this.dbc.close();
        }
        return cus;
    }

    @Override
    public void updatePwd(String newcus_account) throws Exception {
        try{
            this.dao.updatePwd(newcus_account);
        }catch(Exception e ){
            throw e ;
        }finally{
            this.dbc.close();
        }
    }
}
