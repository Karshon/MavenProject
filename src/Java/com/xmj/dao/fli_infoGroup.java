package com.xmj.dao;

import com.xmj.vo.fli_info;

import java.util.ArrayList;
import java.util.List;

public class fli_infoGroup {
    private String total;
    private List<fli_info> rows  = new ArrayList<>();
    public fli_infoGroup(){}

    public List<fli_info> getRows() {
        return rows;
    }

    public void setRows(List<fli_info> rows) {
        this.rows = rows;
    }

    public fli_infoGroup(String total, List<fli_info> listJson){
        this.total = total;
        this.rows = listJson;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }




}
