package cn.itcast.servlets;

import cn.itcast.dao.StuDao;
import cn.itcast.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updatestuServlet")
public class UpdatestuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            // 获取页面的请求参数
            String id = request.getParameter("id");
            String sname = request.getParameter("name");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String address = request.getParameter("address");
            String qq = request.getParameter("qq");
            String birth = request.getParameter("birth");

            //把字符串的参数类型转换
            int iid = Integer.parseInt(id);
            int sage = Integer.parseInt(age);
            Date sbirth = new SimpleDateFormat("yyyy-MM-dd").parse(birth);

            //封装数据
            Student student = new Student(iid, sname, sex, sage, address, qq, sbirth);

            //调用dao的方法
            StuDao dao = new StuDao();
            dao.updatestu(student);
            //转发到查询servlet
            request.getRequestDispatcher("findAllStuServlet").forward(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
