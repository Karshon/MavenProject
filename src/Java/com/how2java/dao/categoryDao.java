package com.how2java.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface categoryDao {
    String queryById(String id);
}
