package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class updatePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String oldcus_pwd = req.getParameter("oldcus_pwd");
        String newcus_pwd = req.getParameter("newcus_pwd");
        HttpSession session = req.getSession();
        String cus_account = (String)session.getAttribute("cus_account");
        Customer cus;
        List<String> info = new ArrayList<String>();
        try{
            cus= DaoFactory.getRegisterDaoInstance().findCustomer(cus_account);


           if(oldcus_pwd.equals(cus.getCus_pwd()))
           {
               try{
                   DaoFactory.getRegisterDaoInstance().updatePwd(newcus_pwd);
                   req.getRequestDispatcher("updatePwdSuc.jsp").forward(req,resp);
               }catch(Exception e){
                   throw e ;
               }
           }
           else{

               req.setAttribute("info","原密码错误！");
               req.getRequestDispatcher("updatePwd.jsp").forward(req,resp);
           }



        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
