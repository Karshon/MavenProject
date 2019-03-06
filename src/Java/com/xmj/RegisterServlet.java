package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String path = "HomePage.jsp";
        String Cus_account = req.getParameter("username");
        String Cus_pwd = req.getParameter("password");
        String Cus_id = req.getParameter("cus_id");
        String Cus_sex = req.getParameter("cus_sex");
        String Cus_telnumber = req.getParameter("cus_telnumber");
        String Cus_email = req.getParameter("cus_email");
        Customer customer = new Customer();
        customer.setCus_account(Cus_account);
        customer.setCus_pwd(Cus_pwd);
        customer.setCus_id(Cus_id);
        customer.setCus_sex(Cus_sex);
        customer.setCus_email(Cus_email);
        customer.setCus_telnumber(Cus_telnumber);
        try {
           DaoFactory.getRegisterDaoInstance().addCustomer(customer);
            HttpSession session=req.getSession();
            session.setAttribute("cus_account",customer.getCus_account());
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException{
        this.doPost(req,resp);
    }
}
