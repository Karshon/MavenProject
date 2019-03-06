package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;
import com.xmj.vo.fli_info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class addBookInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String com_code = req.getParameter("com_code");
        String fli_no =req.getParameter("fli_no");
        String fli_baddress = req.getParameter("fli_baddress");
        String fli_aaddress = req.getParameter("fli_aaddress");
        String fli_type = req.getParameter("fli_type");
        String fli_fare = req.getParameter("fli_fare");
        String fli_number = req.getParameter("fli_number");
        HttpSession session = req.getSession();
        String cus_account = (String)session.getAttribute("cus_account");


        Customer cus = new Customer();
        fli_info fli_Info = new fli_info();


        try{
          cus =   DaoFactory.getRegisterDaoInstance().findCustomer(cus_account);
          fli_Info = DaoFactory.getfli_infoDaoInstance().findFli_info2(fli_no);
        }catch(Exception e ){
            e.printStackTrace();
        }

        int max= Integer.parseInt(fli_number);
        int min = 1;
        int num = new Random().nextInt(max-min+1)+min;

        String boo_number = Integer.toString(num);
        session.setAttribute("cus_id",cus.getCus_id());
        session.setAttribute("com_code",com_code);
        session.setAttribute("fli_no",fli_no);
        session.setAttribute("boo_baddress",fli_baddress);
        session.setAttribute("boo_aaddress",fli_aaddress);
        session.setAttribute("boo_btime",fli_Info.getFli_btime());
        session.setAttribute("boo_atime",fli_Info.getFli_atime());
        session.setAttribute("boo_berth",fli_type);
        session.setAttribute("boo_fare",fli_fare);
        session.setAttribute("boo_number",boo_number);
        req.getRequestDispatcher("confirmInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }
}
