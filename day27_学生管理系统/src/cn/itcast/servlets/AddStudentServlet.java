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

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //设置编码
            request.setCharacterEncoding("utf-8");
            //获取表单数据
            String sname = request.getParameter("sname");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String address = request.getParameter("address");
            String qq = request.getParameter("qq");
            String birth = request.getParameter("birth");

            //封装成学生对象
            Student student = new Student(sname, sex, Integer.parseInt(age), address, qq, new SimpleDateFormat("yyyy-MM-dd").parse(birth));
            StuDao dao = new StuDao();
            dao.addStudent(student);

            //重新回到list页面
            response.sendRedirect(request.getContextPath()+"/findAllStuServlet");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
