package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/findAllStuServlet","*.jsp","/addStudentServlet","/deletestuServlet","/findstubyidServlet","/updatestuServlet"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sp, FilterChain filterChain) throws IOException, ServletException {
            //判断访问当前资源时是否已经登录
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sp;

        HttpSession session = request.getSession();
        String admin = (String) session.getAttribute("admin");

        if(admin != null && !"".equals(admin)){
            filterChain.doFilter(sr,sp);
        }else{
            request.setAttribute("msg","您未登录不能访问!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
