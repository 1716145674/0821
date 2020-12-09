package com.atguigu.controller;

import com.atguigu.pojo.Person;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class UpLoadAndDownLoadController {
    /**
     * springmvc文件上传的方法
     */
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(name = "username") String username,
                         @RequestParam(name = "photo") MultipartFile file,
                         HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        System.out.println(username);
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        //如果文件为空则跳转到失败页面
        if (file.isEmpty()) {
            return "fail";
        }
        //找到文件上传的真实路径
        String realPath = servletContext.getRealPath("/files");
        //创建文件类
        File realFile = new File(realPath, filename);
        //判断此文件类是否可用
        if (!realFile.getParentFile().exists()) {
            realFile.getParentFile().mkdirs();
            System.out.println("创建目录：" + realPath);
        }
        //将文件存到指定位置
        file.transferTo(realFile);
        return "ok";

    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String fileName="d.jpg";
        //获得指定文件的输入流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/files/"+fileName);
        //通过io工具类来解析输入流中的字节数组
        byte[] body = IOUtils.toByteArray(resourceAsStream);
        //获得文件的mimeType类型
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println(mimeType);
        //创建一个包含 响应头 的对象
        MultiValueMap headers = new HttpHeaders();
        //告知浏览器 所接受的对象的mimeType类型
        headers.add("Content-Type",mimeType );
        //告知浏览器如何处理此数据
        headers.add("Content-Disposition","attachment; fileName="+fileName);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body,
                headers, HttpStatus.OK
                );
        return responseEntity;
    }
}
