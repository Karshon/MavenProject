package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class addBookInfoServletAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cus_id = req.getParameter("cus_id");
        String com_code = req.getParameter("com_code");
        String boo_no  = req.getParameter("fli_no");
        String boo_baddress = req.getParameter("boo_baddress");
        String boo_aaddress = req.getParameter("boo_aaddress");
        String boo_btime = req.getParameter("boo_btime");
        String boo_atime = req.getParameter("boo_atime");
        String boo_berth = req.getParameter("boo_berth");
        String flag = "book";

        String boo_number = req.getParameter("boo_number");
        String boo_fare   =req.getParameter("boo_fare");
        Customer cus = new Customer();

        HttpSession session = req.getSession();
        String cus_account = (String)session.getAttribute("cus_account");
        try{
            cus =DaoFactory.getRegisterDaoInstance().findCustomer(cus_account);
        }catch ( Exception e){
            e.printStackTrace();
        }

        if(cus.getCus_integral()>=60) {
            try {
                DaoFactory.getbookinfoDaoInstance().addbookinfo(cus_id, com_code, boo_no, boo_baddress, boo_aaddress,
                        boo_btime, boo_atime,
                        boo_berth, boo_number, boo_fare);
                DaoFactory.getupdateNumDaoInstance().updateNum(boo_berth, boo_no,flag);

            } catch (Exception e) {
                e.printStackTrace();
            }

            req.getRequestDispatcher("booksuccess.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("bookfail.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
