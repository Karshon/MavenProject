package com.xmj.dao;

import com.xmj.vo.Customer;
import com.xmj.vo.bookinfo;

import java.util.ArrayList;
import java.util.List;

public class cusGroup {
    private String total;
    private List<Customer> rows = new ArrayList<>();

    public cusGroup(String total, List<Customer> list){
        this.total = total;
        this.rows = list;
    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Customer> getRows() {
        return rows;
    }

    public void setRows(List<Customer> rows) {
        this.rows = rows;
    }
}
