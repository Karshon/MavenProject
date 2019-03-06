package com.xmj;

import com.xmj.dao.impl.CusDaoImpl;
import com.xmj.dbc.DatabaseConnection;
import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void  doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String username= req.getParameter("username");
            String password = req.getParameter("password");
            List<String > info = new ArrayList<String >();
            Customer customer = new Customer();
        customer.setCus_account(username);
        customer.setCus_pwd(password);
        try{
            if(DaoFactory.getCusDaoInstance().findLogin(customer)){
                HttpSession session=req.getSession();
                session.setAttribute("cus_account",customer.getCus_account());
                req.getRequestDispatcher("HomePage.jsp").forward(req,resp);
            }else{
                info.add("登录失败");
                req.setAttribute("info",info);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
