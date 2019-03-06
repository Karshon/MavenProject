package com.xmj.factory;

import com.xmj.dao.*;
import com.xmj.dao.proxy.*;

public class DaoFactory {
    public static CusDao getCusDaoInstance(){
        return  new CusDaoProxy();
    }
    public static RegisterDao getRegisterDaoInstance(){ return new RegisterDaoProxy();
    }
    public static fli_infoDao getfli_infoDaoInstance(){
        return new fli_infoDaoProxy();
    }
    public static bookinfoDao getbookinfoDaoInstance(){
        return new bookinfoDaoImplProxy();
    }
    public static updateNumDao getupdateNumDaoInstance(){
        return new updateNumProxy();
    }
    public static refundrecordDao getrefundrecordDaoInstance(){return new refundrecordDaoProxy();}
}
