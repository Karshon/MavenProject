package com.xmj;

import com.xmj.dao.cusGroup;
import com.xmj.dao.fli_infoGroup;
import com.xmj.factory.DaoFactory;
import com.xmj.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class admin_findCusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cus_account = req.getParameter("cus_account");
        Customer customer = new Customer();
        try{
            customer = DaoFactory.getCusDaoInstance().findCustomer(cus_account);
        }catch(Exception e){
            e.printStackTrace();
        }


       if(customer.getCus_id()!=null) {
           List<Customer> list = new ArrayList<>();
           list.add(customer);
           String total = Integer.toString(list.size());


           cusGroup cusGroup = new cusGroup(total, list);
           String cusGroupJson = JSON.toJSONString(cusGroup);

           resp.getWriter().write(cusGroupJson);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
