package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet生命周期 Servlet 通过调用 init () 方法进行初始化。 Servlet 调用 service() 方法来处理客户端的请求。 Servlet 通过调用
 * destroy() 方法终止（结束）。 最后，Servlet 是由 JVM 的垃圾回收器进行垃圾回收的。
 *
 * 说明:
 * init()方法被设计成只调用一次。它在第一次创建Servlet时被调用，在后续每次用户请求时不再调用。
 * service() 方法是执行实际任务的主要方法。Servlet 容器（即Web 服务器）调用 service() 方法来处理来自客户端（浏览器）的请求，并把格式化的响应写回给客户端。
 * 每次服务器接收到一个 Servlet请求时，服务器会产生一个新的线程并调用服务。
 * service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE 等），并在适当的时候调用doGet、doPost、doPut，doDelete 等方法。
 *
 * @author SuChenghe
 * @date 2019/1/19 16:01
 */
public class HttpServletDemo extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        //执行必需的初始化
        System.out.println("Servlet初始化");
        message = "Hello World";
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method," + message);
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method" + message);
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet已被销毁");
    }

}
