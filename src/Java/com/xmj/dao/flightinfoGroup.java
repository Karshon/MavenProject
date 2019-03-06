package com.xmj.dao;

import com.xmj.vo.fli_info;
import com.xmj.vo.flightinfomation;

import java.util.ArrayList;
import java.util.List;

public class flightinfoGroup {
    private String total;

    private List<flightinfomation> rows  = new ArrayList<>();
    public flightinfoGroup(){}
    public flightinfoGroup(String total, List<flightinfomation> list){
        this.total = total;
        this.rows = list;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<flightinfomation> getRows() {
        return rows;
    }

    public void setRows(List<flightinfomation> rows) {
        this.rows = rows;
    }

}
