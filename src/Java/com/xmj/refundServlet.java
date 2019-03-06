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

public class refundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cus_id = req.getParameter("cus_id");
        String boo_time = req.getParameter("boo_time");
        String boo_number = req.getParameter("boo_number");
        String boo_no = req.getParameter("boo_no");
        String boo_berth = req.getParameter("boo_berth");

         int  boo_autoid = 0;
         String flag = "refund";
        try{
            boo_autoid = DaoFactory.getbookinfoDaoInstance().findBoo_autoid(cus_id,boo_time);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            DaoFactory.getbookinfoDaoInstance().updateflag_pass(cus_id,boo_time);
            DaoFactory.getrefundrecordDaoInstance().addrefundrecord(boo_autoid,boo_number);
            DaoFactory.getCusDaoInstance().updateCus_integral(cus_id,flag);
            DaoFactory.getupdateNumDaoInstance().updateNum(boo_berth,boo_no,flag);
        }catch (Exception e ){
            e.printStackTrace();
        }
        List<bookinfo> list = new ArrayList<>();

        try{
          list =  DaoFactory.getbookinfoDaoInstance().findNoPay(cus_id,"1");
        }catch (Exception e){
            e.printStackTrace();
        }
        String total = Integer.toString(list.size());


        bookinfoGroup bookinGroup = new bookinfoGroup(total,list);
        String bookinfoGroupJson = JSON.toJSONString(bookinGroup);

        resp.getWriter().write(bookinfoGroupJson);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
