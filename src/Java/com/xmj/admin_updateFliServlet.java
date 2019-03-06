package com.xmj;

import com.xmj.factory.DaoFactory;
import com.xmj.vo.flightinfomation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class admin_updateFliServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fli_no = req.getParameter("fli_no");
        List<flightinfomation> list = new ArrayList();
        try{
            list = DaoFactory.getfli_infoDaoInstance().findFli_info(fli_no);
        }catch (Exception e){
            e.printStackTrace();
        }
        flightinfomation flightinfo = new flightinfomation();
        for( int i = 0 ; i < list.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            flightinfo = list.get(i);
        }
        req.setAttribute("flightinfo",flightinfo);
        req.getRequestDispatcher("admin_updateFli.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
