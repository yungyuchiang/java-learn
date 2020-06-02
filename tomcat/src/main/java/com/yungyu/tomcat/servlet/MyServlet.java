package com.yungyu.tomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: j1280
 * @Date: Create in 2020/2/27
 * @Description:
 * @Modified:
 */
@WebServlet(name = "myServlet", urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        System.out.println("Hello, Servlet 3");
        PrintWriter out = resp.getWriter();
        out.println("Hello, Servlet 3");
    }
}
