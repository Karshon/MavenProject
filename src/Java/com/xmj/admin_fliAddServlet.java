package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.flightinfomation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class admin_fliAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String com_code = req.getParameter("com_code");
        String air_code = req.getParameter("air_code");
        String fli_no =   req.getParameter("fli_no");
        String fli_baddress = req.getParameter("fli_baddress");
        String fli_aaddress = req.getParameter("fli_aaddress");
        String fli_btime    = req.getParameter("fli_btime");
        String fli_atime    = req.getParameter("fli_atime");
        int fli_Fnumber  = Integer.parseInt(req.getParameter("fli_Fnumber"));
        int fli_Cnumber =  Integer.parseInt(req.getParameter("fli_Cnumber"));
        int  fli_Ynumber = Integer.parseInt(req.getParameter("fli_Ynumber"));
        Float fli_Ffare   = Float.parseFloat(req.getParameter("fli_Ffare"));
       Float fli_Cfare   = Float.parseFloat(req.getParameter("fli_Cfare"));
        Float fli_Yfare   = Float.parseFloat(req.getParameter("fli_Yfare"));
        String fli_refundtime = req.getParameter("fli_refundtime");
        String fli_everyday = "0";
        Float fli_discount = 0.0f;
        boolean fli_refund = false;
        boolean flag = true ;
        flightinfomation flightinfo = new flightinfomation();
        flightinfo.setCom_code(com_code);
        flightinfo.setAir_code(air_code);
        flightinfo.setFli_everyday(fli_everyday);
        flightinfo.setFli_no(fli_no);
        flightinfo.setFli_dicount(fli_discount);
        flightinfo.setFli_baddress(fli_baddress);
        flightinfo.setFli_aaddress(fli_aaddress);
        flightinfo.setFli_btime(fli_btime);
        flightinfo.setFli_atime(fli_atime);
        flightinfo.setFli_Fnumber(fli_Fnumber);
        flightinfo.setFli_Cnumber(fli_Cnumber);
        flightinfo.setFli_Ynumber(fli_Ynumber);
        flightinfo.setFli_Ffare(fli_Ffare);
        flightinfo.setFli_Cfare(fli_Cfare);
        flightinfo.setFli_Yfare(fli_Yfare);
        flightinfo.setFli_refundtime(fli_refundtime);
        flightinfo.setFli_refund(fli_refund);
        flightinfo.setFlag(flag);
        try{
            DaoFactory.getfli_infoDaoInstance().addFli_info(flightinfo);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
