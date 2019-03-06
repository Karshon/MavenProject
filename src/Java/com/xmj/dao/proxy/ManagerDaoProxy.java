package com.xmj.dao.proxy;

import com.xmj.dao.ManagerDao;
import com.xmj.dao.impl.ManagerDaoImpl;
import com.xmj.dbc.DatabaseConnection;
import com.xmj.vo.Manager;

public class ManagerDaoProxy implements ManagerDao {
    private DatabaseConnection dbc = null;
    private ManagerDao dao = null;
    public ManagerDaoProxy(){
        try{
            this.dbc = new DatabaseConnection();
        }catch (Exception e ){
            e.printStackTrace();
        }
        this.dao = new ManagerDaoImpl(this.dbc.getConnection());
    }
    @Override
    public Manager findManager(String man_account,String man_pwd) throws Exception {
        Manager manager = new Manager();
        try{
            manager = this.dao.findManager(man_account,man_pwd);
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close();
        }
        return manager;
    }
}
