package cn.itcast.filter;

import cn.itcast.domain.Administrator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"*.jsp","/findAllStuServlet","/addStudentServlet"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if(request.getRequestURI().contains("login.jsp")){
            chain.doFilter(req, resp);
            return;
        }
        String path = ((HttpServletRequest) req).getRequestURL().toString();
        HttpSession session = request.getSession();
        Administrator admin = (Administrator) session.getAttribute("user");

        if(admin!=null){
            chain.doFilter(req, resp);
        }else{
            request.getSession().setAttribute("msg","请先登录!");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
