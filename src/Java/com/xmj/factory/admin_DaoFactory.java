package com.xmj.factory;

import com.xmj.dao.ManagerDao;
import com.xmj.dao.proxy.ManagerDaoProxy;

public class admin_DaoFactory {
    public static ManagerDao getManagerDaoInstance() {return new ManagerDaoProxy(); }
}
