package com;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //解决汉字乱码问题
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        //得到某个参数值
//        out.print("得到用户名：" + request.getParameter("username") + "<br>");
//        //得到一组同名的值
//        String[] hobbies = request.getParameterValues("hobby");
//        out.print("爱好是：" + Arrays.toString(hobbies) + "<br>");
//        out.print("<hr>");
//        //得到所有参数的名字
//        Enumeration<String> names = request.getParameterNames();
//        while (names.hasMoreElements()) {
//            //其中的一个名字
//            String name = names.nextElement();
//            out.print("参数名：" + name + ",  参数值：" + request.getParameter(name) + "<br>");
//        }
//        out.print("<hr>");
//        //得到所有的键和值
//        Map<String, String[]> map = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = map.entrySet();
//        //遍历set集合
//        for (Map.Entry<String, String[]> entry : entries) {
//            out.print(entry.getKey() + "=" + Arrays.toString(entry.getValue()) + "<br>");
//        }
//        Map<String, String[]> map2 = request.getParameterMap();
//        Set<String> set = map2.keySet();
//        for(String s:set){
//            System.out.println(s+" "+Arrays.toString(map2.get(s)));
//        }
        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");      //一般为字符流
        ServletContext application=getServletContext();//得到上下文对象   一般本地不用这种方法
        InputStream in= application.getResourceAsStream("/WEB-INF/11.jpg");
        //得到一个输出流
        OutputStream out = response.getOutputStream();   //字节流
        //设置响应头
        response.setContentType("image/jpeg");
        //输出到浏览器上
        int len = 0;
        byte[] b = new byte[1024];
        while((len = in.read(b))!=-1) {
            out.write(b,0,len);
        }
        //关闭
        in.close();
        out.close();
    }


}
