package cn.itcast.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //java awt swing abstract window tools
        //创建图片对象
        int width = 100;
        int height = 60;
        //创建了一个长100宽60的图片
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //对其进行美化
        Graphics pen = img.getGraphics();//获取绘制工具对象
        //背景色
        pen.setColor(Color.pink);
        pen.fillRect(0,0,width,height);
        //边框
        pen.setColor(Color.black);
        pen.drawRect(0,0,width-1,height-1);
        //书写内容
        pen.setFont(new Font("楷体",Font.PLAIN,30));

        StringBuilder sb = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random r = new Random();
        for (int i = 1;i < 5;i++) {
            int index = r.nextInt(chars.length());//0
            String var = chars.charAt(index)+"";
            pen.drawString(var,width/5*i-10,height/2+10);

            sb.append(var);
        }

        String servercode = sb.toString();

        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("servercode",servercode);

//        pen.drawString("b",30,45);
//        pen.drawString("c",50,35);
//        pen.drawString("d",70,40);
        //输出
//        ImageIO.write(img,"jpg",new FileOutputStream("D://code.jpg"));
        //把生成的验证码图片输出到页面上
        ImageIO.write(img,"jpg",response.getOutputStream());
        //response.getoutputstream
        //response.getWriter
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
