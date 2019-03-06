package com.xmj.dao;

import com.xmj.vo.fli_info;
import com.xmj.vo.flightinfomation;

import java.util.List;

public interface fli_infoDao {
    public List<fli_info> findFli_info(String fli_baddress, String fli_aaddress, String fli_btime,String fli_number,String fli_fare)throws Exception;
    public fli_info findFli_info2(String fli_no) throws  Exception;
    public void updateflag_pay(String cus_id,String boo_time ) throws Exception;
    public void updateFli_info(flightinfomation flightinfo) throws Exception;
    public void addFli_info(flightinfomation flightinfo) throws Exception;
    public List<flightinfomation> findFli_info(String fli_no) throws Exception;
    public void updateFli_refund(String fli_no ,boolean fli_refund )throws Exception ;
}
