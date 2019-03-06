package com.xmj.dao;

import com.xmj.vo.Customer;

public interface RegisterDao  {
    public void addCustomer(Customer customer) throws Exception ;
    public Customer findCustomer(String cus_account) throws Exception;
    public void updatePwd(String newcus_account) throws Exception;

}
