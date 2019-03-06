package com.xmj;

import com.alibaba.fastjson.JSON;
import com.xmj.dao.flightinfoGroup;
import com.xmj.factory.DaoFactory;
import com.xmj.vo.flightinfomation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class updateFli_refundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fli_no = req.getParameter("fli_no");

        boolean fli_refund = true;
        try{
            DaoFactory.getfli_infoDaoInstance().updateFli_refund(fli_no,fli_refund);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<flightinfomation> list = new ArrayList<>();
        try{
            list = DaoFactory.getfli_infoDaoInstance().findFli_info(fli_no);
        }catch (Exception e ){
            e.printStackTrace();
        }
        String total = Integer.toString(list.size());


        flightinfoGroup flightinfoGroup = new flightinfoGroup(total,list);
        String flightinfoGroupJson = JSON.toJSONString(flightinfoGroup);

        resp.getWriter().write(flightinfoGroupJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
