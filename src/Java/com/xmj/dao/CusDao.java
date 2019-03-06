package com.xmj.dao;

import com.xmj.vo.Customer;

public interface CusDao {
    public boolean findLogin(Customer cus) throws Exception;
    public Customer findCustomer(String cus_account)throws Exception;
    public String findCus_id(String cus_account) throws Exception ;
    public void updateCus_integral(String cus_id,String flag ) throws Exception;
    public void deleteCus(String cus_account) throws Exception ;
    public void updateCus(String cus_telnumber,String cus_email,String cus_account) throws Exception ;
}
