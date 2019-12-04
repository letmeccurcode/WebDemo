package cn.itcast.servlets;

import cn.itcast.dao.StuDao;
import cn.itcast.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllStuServlet")
public class FindAllStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //去数据库中查询stu这张表
        StuDao stuDao = new StuDao();
        List<Student> list = stuDao.findAllStu();
        //把查询到的所有学生放入集合 并转发给list.jsp
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
