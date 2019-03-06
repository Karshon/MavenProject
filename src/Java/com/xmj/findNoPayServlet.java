package com.xmj;

import com.alibaba.fastjson.JSON;
import com.xmj.dao.bookinfoGroup;
import com.xmj.dao.fli_infoGroup;
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

public class findNoPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("cus_account");

        String cus_id = null;
        String flag_pay = "0";
        //取出cus_id
        try{
            cus_id = DaoFactory.getCusDaoInstance().findCus_id((String)session.getAttribute("cus_account"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //取出 list 列表
        List<bookinfo> list = new ArrayList<>();
         try{
            list = DaoFactory.getbookinfoDaoInstance().findNoPay(cus_id,flag_pay);
        }catch(Exception e){
             e.printStackTrace();
         }
        String total = Integer.toString(list.size());
        bookinfoGroup bookinGroup = new bookinfoGroup(total,list);
        String bookinfoGroupJson = JSON.toJSONString(bookinGroup);
        req.setAttribute("bookinfoGroupJson",bookinfoGroupJson);
        req.getRequestDispatcher("findNoPay.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
