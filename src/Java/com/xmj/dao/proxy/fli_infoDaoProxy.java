package com.xmj.dao.proxy;

import com.xmj.dao.fli_infoDao;
import com.xmj.dao.impl.fli_infoDaoImpl;
import com.xmj.dbc.DatabaseConnection;
import com.xmj.vo.fli_info;
import com.xmj.vo.flightinfomation;

import java.util.ArrayList;
import java.util.List;

public class fli_infoDaoProxy implements fli_infoDao {
    private DatabaseConnection dbc = null;
    private fli_infoDao dao = null;
    public fli_infoDaoProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dao = new fli_infoDaoImpl(this.dbc.getConnection());
    }
    @Override
    public List<fli_info> findFli_info(String fli_baddress, String fli_aaddress, String fli_btime,String fli_number,String fli_fare)
            throws Exception {
        List<fli_info> list = new ArrayList<>();
        try{
            list = this.dao.findFli_info( fli_baddress,  fli_aaddress,  fli_btime,fli_number,fli_fare);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return list;
    }

    @Override
    public fli_info findFli_info2(String fli_no) throws Exception {
       fli_info fli_Info = new fli_info();
        try{
            fli_Info = this.dao.findFli_info2(fli_no);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return fli_Info;
    }

    @Override
    public void updateflag_pay(String cus_id, String boo_time) throws Exception {
        try{
            this.dao.updateflag_pay(cus_id,boo_time);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public void updateFli_info(flightinfomation flightinfo) throws Exception {
        try{
            this.dao.updateFli_info(flightinfo);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public void addFli_info(flightinfomation flightinfo) throws Exception {
        try{
            this.dao.addFli_info(flightinfo);
        }catch (Exception e){
            throw e ;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public List<flightinfomation> findFli_info(String fli_no) throws Exception {
        List<flightinfomation> list = new ArrayList<>();
        try{
            list = this.dao.findFli_info(fli_no);
        }catch (Exception e){
            throw e ;
        }finally{
            this.dbc.close();
        }
        return list;
    }

    @Override
    public void updateFli_refund(String fli_no, boolean fli_refund) throws Exception {
        try{
            this.dao.updateFli_refund(fli_no,fli_refund);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
    }
}
