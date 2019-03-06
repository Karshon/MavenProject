package com.xmj;

import com.xmj.dao.fli_infoGroup;
import com.xmj.factory.DaoFactory;
import com.xmj.vo.fli_info;


import com.alibaba.fastjson.JSON;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class loadGdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fli_baddress = req.getParameter("fli_baddress");
        String fli_aaddress = req.getParameter("fli_aaddress");
        String fli_btime = req.getParameter("fli_btime");
        String fli_type = req.getParameter("fli_type");
        String fli_number;
        String fli_fare;
        if(fli_type.equals("头等舱")){
            fli_number = "fli_Fnumber";
            fli_fare = "fli_Ffare";
        }else  if (fli_type.equals("公务舱")){
            fli_number = "fli_Cnumber";
            fli_fare = "fli_Cfare";
        }else{
            fli_number = "fli_Ynumber";
            fli_fare = "fli_Yfare";
        }
        List<fli_info> list = new ArrayList<>();
        try {
            list = DaoFactory.getfli_infoDaoInstance().findFli_info(fli_baddress, fli_aaddress, fli_btime,fli_number,fli_fare);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String total = Integer.toString(list.size());
        String listJson = JSON.toJSONString(list);
        fli_infoGroup userGroup = new fli_infoGroup(total,list);
        String userGroupJson = JSON.toJSONString(userGroup);
        resp.getWriter().write(userGroupJson);
    }
}
