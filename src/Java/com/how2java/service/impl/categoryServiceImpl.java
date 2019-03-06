package com.how2java.service.impl;

import com.how2java.dao.categoryDao;
import com.how2java.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class categoryServiceImpl implements categoryService {
    @Autowired
    categoryDao cateDao;
    public String getCategoryName(String id ){
        return cateDao.queryById(id);
    }

}
