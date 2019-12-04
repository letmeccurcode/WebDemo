package cn.itcast.servlets;

import cn.itcast.dao.StuDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletestuServlet")
public class DeleteStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从页面上获取要删除的学生的id
        String id = request.getParameter("id");
        int iid = Integer.parseInt(id);
        //创建studao
        StuDao dao = new StuDao();
        dao.deletestuByID(iid);
        //回到list页面
        response.sendRedirect(request.getContextPath()+"/findAllStuServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
