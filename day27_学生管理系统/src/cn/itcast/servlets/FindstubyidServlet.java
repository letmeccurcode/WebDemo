package cn.itcast.servlets;

import cn.itcast.dao.StuDao;
import cn.itcast.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findstubyidServlet")
public class FindstubyidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从页面上获取id的值
        String id = request.getParameter("id");
    //把字符串的id转换成int的id
    int iid = Integer.parseInt(id);

    StuDao dao = new StuDao();
    //根据id查找学生的记录 并封装成一个学生对象
    Student stu = dao.findstuByID(iid);

    //把学生对象存入request域中 并转发到upate页面进行获取和展示
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("update.jsp").forward(request,response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
