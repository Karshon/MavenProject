package com.xmj.dao.proxy;

import com.xmj.dao.impl.refundrecordDaoImpl;
import com.xmj.dao.refundrecordDao;
import com.xmj.dbc.DatabaseConnection;

public class refundrecordDaoProxy implements refundrecordDao {
    private DatabaseConnection dbc = null;
    private refundrecordDao dao = null;
    public refundrecordDaoProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dao = new refundrecordDaoImpl(this.dbc .getConnection());
    }
    @Override
    public void addrefundrecord(int boo_autoid, String boo_number) throws Exception {
        try{
            this.dao.addrefundrecord(boo_autoid,boo_number);
        }catch (Exception e ){
            throw e ;
        }finally {
            this.dbc.close();
        }
    }
}
