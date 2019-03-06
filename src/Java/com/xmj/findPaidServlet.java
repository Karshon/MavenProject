package com.xmj;

import com.alibaba.fastjson.JSON;
import com.xmj.dao.bookinfoGroup;
import com.xmj.factory.DaoFactory;
import com.xmj.vo.bookinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class findPaidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String cus_account = (String)session.getAttribute("cus_account");
        List<bookinfo> list = new ArrayList<>();
        try{
            String cus_id = DaoFactory.getCusDaoInstance().findCus_id(cus_account);
           list =  DaoFactory.getbookinfoDaoInstance().findNoPay(cus_id,"1");
        }catch(Exception e){
            e.printStackTrace();
        }
        String total = Integer.toString(list.size());


        bookinfoGroup bookinGroup = new bookinfoGroup(total,list);
        String bookinfoGroupJson = JSON.toJSONString(bookinGroup);
        req.setAttribute("bookinfoGroupJson",bookinfoGroupJson);
        req.getRequestDispatcher("findPaidPay.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
