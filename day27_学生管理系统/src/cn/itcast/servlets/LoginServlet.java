package cn.itcast.servlets;

import cn.itcast.dao.AdminDao;
import cn.itcast.domain.Administrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置请求参数编码格式
        request.setCharacterEncoding("utf-8");

        //获取验证码
        String c_code = request.getParameter("verifycode");
        //从session中取出生成的验证码字符串
        HttpSession session = request.getSession();
        String s_code = (String) session.getAttribute("servercode");

        //判断用户输入的验证码是否正确
        if(!c_code.equalsIgnoreCase(s_code)){
            request.setAttribute("msg","验证码有误!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //去数据库中查找是否存在该用户名和密码的表记录 web_test/administrator
        Administrator admin = new Administrator(username, password);
        //创建AdminDao
        AdminDao dao = new AdminDao();
        Administrator result = dao.findAdminByNameAndPswd(admin);
        session.setAttribute("user",result);
        if(result != null){
            //跳转到index
            request.setAttribute("admin",result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            //用户名或者密码有问题 跳转到登陆页面
            request.getSession().setAttribute("msg","用户名或者密码有误!");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
