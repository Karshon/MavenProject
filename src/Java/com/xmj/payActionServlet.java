package com.xmj;

import com.xmj.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class payActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cus_id= req.getParameter("cus_id");
        String boo_time = req.getParameter("boo_time");
        String flag = "add";
        try{
            DaoFactory.getfli_infoDaoInstance().updateflag_pay(cus_id,boo_time);
            DaoFactory.getCusDaoInstance().updateCus_integral(cus_id,flag);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getRequestDispatcher("paySuccess.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
