package com.xmj.dao.proxy;

import com.xmj.dao.bookinfoDao;
import com.xmj.dao.impl.bookinfoDaoImpl;
import com.xmj.dbc.DatabaseConnection;
import com.xmj.vo.bookinfo;

import java.util.ArrayList;
import java.util.List;

public class bookinfoDaoImplProxy implements bookinfoDao {
    private DatabaseConnection dbc = null;
    private bookinfoDao dao = null;
    public bookinfoDaoImplProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch (Exception e ){
            e.printStackTrace();
        }
        this.dao = new bookinfoDaoImpl(this.dbc.getConnection());
    }
    @Override
    public void addbookinfo(String cus_id, String com_code, String fli_no, String boo_baddress, String boo_aaddress, String boo_btime, String boo_atime, String boo_berth, String boo_number, String boo_fare) throws Exception {
       try{
           this.dao.addbookinfo( cus_id,  com_code,  fli_no,  boo_baddress,  boo_aaddress,
                    boo_btime,  boo_atime,
                    boo_berth,  boo_number,  boo_fare);
       }catch (Exception e ){
           throw  e;
       }finally {
           this.dbc.close();
       }
    }

    @Override
    public List<bookinfo> findNoPay(String cus_id, String  flag_pay) throws Exception {
        List<bookinfo>  list = new ArrayList<>();
        try{
           list =  this.dao.findNoPay(cus_id,flag_pay);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }

        return list;
    }

    @Override
    public void updateflag_pass(String cus_id, String boo_time) throws Exception {
        try{
            this.dao.updateflag_pass(cus_id,boo_time);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public int findBoo_autoid(String cus_id, String boo_time) throws Exception {
        int boo_autoid = 0;
        try{
            boo_autoid = this.dao.findBoo_autoid(cus_id,boo_time);
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
             this.dbc.close();
        }
        return boo_autoid;
    }
}
