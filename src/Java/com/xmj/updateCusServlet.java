package com.xmj;

import com.xmj.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateCusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cus_telnumber = req.getParameter("cus_telnumber");
        String cus_email = req.getParameter("cus_email");
        String cus_account = req.getParameter("cus_account");
        try{
            DaoFactory.getCusDaoInstance().updateCus(cus_telnumber,cus_email,cus_account);
            req.getRequestDispatcher("CusInfoServlet").forward(req,resp);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
