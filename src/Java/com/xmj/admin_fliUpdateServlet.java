package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.flightinfomation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class admin_fliUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        flightinfomation flightinfo = new flightinfomation();
        String fli_no = req.getParameter("fli_no");
        Float  fli_Ffare = Float.valueOf(req.getParameter("fli_Ffare"));

        Float fli_Cfare = Float.valueOf(req.getParameter("fli_Cfare"));
        Float fli_Yfare = Float.valueOf(req.getParameter("fli_Yfare"));
        String fli_refundtime = req.getParameter("fli_refundtime");
        flightinfo.setFli_no(fli_no);
        flightinfo.setFli_Ffare(fli_Ffare);
        flightinfo.setFli_Cfare(fli_Cfare);
        flightinfo.setFli_Yfare(fli_Yfare);
        flightinfo.setFli_refundtime(fli_refundtime);
        try{
            DaoFactory.getfli_infoDaoInstance().updateFli_info(flightinfo);
            req.getRequestDispatcher("admin_findFli.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
