package com.xmj;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CusInfoServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        HttpSession session = req.getSession();
        String cus_account = (String)session.getAttribute("cus_account");
        Customer cus;
        try{
            cus=DaoFactory.getRegisterDaoInstance().findCustomer(cus_account);
            req.setAttribute("Customer",cus);
        }catch(Exception e){
            e.printStackTrace();
        }
        req.getRequestDispatcher("CusInformation.jsp").forward(req,resp);

    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException{
        this.doPost(req,resp);
    }
}
