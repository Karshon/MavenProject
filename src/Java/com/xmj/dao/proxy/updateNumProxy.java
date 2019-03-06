package com.xmj.dao.proxy;

import com.xmj.dao.impl.updateNumDaoImpl;
import com.xmj.dao.updateNumDao;
import com.xmj.dbc.DatabaseConnection;

public class updateNumProxy implements updateNumDao {
    private DatabaseConnection dbc = null;
    private updateNumDao dao = null;
    public updateNumProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dao = new updateNumDaoImpl(this.dbc.getConnection());
    }
    @Override
    public void updateNum(String boo_berth,String boo_no,String flag) throws Exception {
        try{
            this.dao.updateNum(boo_berth,boo_no,flag);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }
}
