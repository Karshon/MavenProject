package com.xmj.dao;

import com.xmj.vo.Manager;

public interface ManagerDao {
    public Manager findManager (String man_account,String man_pwd )throws  Exception;
}
