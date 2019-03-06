package com.xmj.dao;

import com.xmj.vo.bookinfo;

import java.util.List;

public interface bookinfoDao {
    public void addbookinfo(String cus_id,String com_code,String fli_no,String boo_baddress,
                            String boo_aaddress,String boo_btime,String boo_atime,String boo_berth,
                            String boo_number,String boo_fare)throws Exception;
    public List<bookinfo> findNoPay(String cus_id,String  flag_pay ) throws Exception;
    public void updateflag_pass(String cus_id ,String boo_time) throws Exception ;
    public int findBoo_autoid(String cus_id,String boo_time) throws Exception;
}
