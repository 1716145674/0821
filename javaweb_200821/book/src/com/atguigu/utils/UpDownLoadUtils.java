package com.atguigu.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;


public class UpDownLoadUtils  {


    private  <T> T upload(HttpServletRequest request,T bean) {

        //1.先判断是否是上传的协议
        boolean isMutipatr = ServletFileUpload.isMultipartContent(request);
        if (isMutipatr) {
            try {
                //2.若果是创建一个文件工厂
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                //3.创建一个用来解析上传协议的类servletFileUpload
                ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
                //4.解析request数据
                List<FileItem> list = fileUpload.parseRequest(request);
                System.out.println(list.size());
                //5.遍历处理的每一个表单项
                for (FileItem fileItem : list) {
                    //判断是否是普通的表单项，还是上传的文件项
                    boolean isFromField = fileItem.isFormField();
                    if (isFromField) {
                        System.out.println(isFromField);
                        //获取表单项name的值
                        System.out.println(fileItem.getFieldName());
                        //获得表单项的值
                        System.out.println(fileItem.getString());

                    } else {
                        //打印测试
                        System.out.println(fileItem.isFormField());
                        System.out.println(fileItem.getFieldName());
                        //获得文件名
                        System.out.println(fileItem.getName());
                        //生成uuid名字
                        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                        System.out.println(uuid);
                        //保存到工程的upload目录下
                        File file = new File(request.getServletContext().getRealPath("/upload") + "/" + uuid + "_" + fileItem.getName());
                        System.out.println("file路径：" + file);
                        //把文件写入到指定路径
                        fileItem.write(file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("不是合法的文件上传！！");
        }
        return bean;
    }


}
