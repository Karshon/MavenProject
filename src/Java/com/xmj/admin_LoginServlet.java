package com.xmj;


import com.xmj.factory.admin_DaoFactory;
import com.xmj.vo.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class admin_LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String man_account = req.getParameter("username");
        String man_pwd = req.getParameter("password");
        Manager manager = new Manager();
       try{
            manager = admin_DaoFactory.getManagerDaoInstance().findManager(man_account,man_pwd);
          if(manager.getMan_email()!=null){
              HttpSession session = req.getSession();
              session.setAttribute("manager",manager);
              req.getRequestDispatcher("admin_HomePage.jsp").forward(req,resp);
          }else {
              String message = "登录失败！";
              req.setAttribute("message",message);
              req.getRequestDispatcher("admin_index.jsp").forward(req,resp);
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
