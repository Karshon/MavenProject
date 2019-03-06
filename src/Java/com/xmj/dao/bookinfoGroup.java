package com.xmj.dao;

import com.xmj.vo.bookinfo;

import java.util.ArrayList;
import java.util.List;

public class bookinfoGroup {
    private String total;
    private List<bookinfo> rows = new ArrayList<>();

    public bookinfoGroup(String total, List<bookinfo> list){
        this.total = total;
        this.rows = list;
    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<bookinfo> getRows() {
        return rows;
    }

    public void setRows(List<bookinfo> rows) {
        this.rows = rows;
    }
}
