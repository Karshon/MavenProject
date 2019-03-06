package com.xmj;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();

        if(session.getAttribute("cus_account")!=null){
            chain.doFilter(request,response);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,response);
        }
    }

    @Override
    public void destroy() {

    }
}
