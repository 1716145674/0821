package com.atguigu.utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(value = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        //1.获取下载的请求路径参数
        String filename="屏幕截图(398).png";
        //5.告诉客户端下载的文件的类型
        String mimeType =servletContext.getMimeType(filename);
        System.out.println(mimeType);
        response.setContentType(mimeType);
        //6.通过设置响应头，告诉客户端，收到的数据，用于下载
        /**
         *Content-Disposition 表示收到的内容怎么处理<br/>
         * attachment 表示附件，用于下载 <br/>
         * filename=文件名 <br/>
         */
        response.setHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        //2.获取文件的输入流
        InputStream inputStream = servletContext.getResourceAsStream("/upload/" + filename);
        //3.获取响应的文件的输入流
        ServletOutputStream outputStream = response.getOutputStream();
        //4.利用jar包的ioUtils的工具来实现 文件从输入流到输出流的copy(注意必须是org.apache.common.io下的)
        IOUtils.copy(inputStream,outputStream);
        //关闭流
        inputStream.close();
        outputStream.close();
    }


}
