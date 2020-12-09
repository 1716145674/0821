package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(value = "/manager/bookServlet")
public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * 显示需要修改的图书的信息
     *
     * @param request
     * @param response
     */
    public void showDetails(HttpServletRequest request, HttpServletResponse response) {
        //根据jsp传递的id去数据里找book对象
        String idStr = request.getParameter("id");
        Book tempBook = bookService.queryBookById(Integer.parseInt(idStr));
        String pageNo = request.getParameter("pageNo");
        //封装到域属性中转发到book_edit.jsp页面
        request.setAttribute("tempBook", tempBook);
        try {
            request.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo=" + pageNo).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改数据库中对应的图书
     *
     * @param request
     * @param response
     */
    public void update(HttpServletRequest request, HttpServletResponse response) {

        try {
            //获得请求的数据
            Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
            bookService.updateBook(book);
            //重定向到指定页面
            response.sendRedirect(request.getContextPath() + "/manager/bookServlet?actionMethod=page&pageNo=" + request.getParameter("pageNo"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 删除数据库中对应的图书
     *
     * @param request
     * @param response
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            bookService.deleteBookById(id);
            response.sendRedirect(getServletContext().getContextPath() + "/manager/bookServlet?actionMethod=page&pageNo=" + request.getParameter("pageNo"));
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 分页显示所有的记录
     *
     * @param request
     * @param response
     */
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得客户端传递过来的当前页面pageNo的值 若出错则为默认值0
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);

        //获得客户端传递过来的每页显示的记录数pageSize的值 若出错则为Page的默认值
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用service的方法获得封装了数据的page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        //设置page的url
        page.setUrl("manager/bookServlet?actionMethod=page");

        //设置request域对象
        request.setAttribute("page", page);

        //转发到book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }

    /**
     * 实现可以上传封面的创建图书的方法
     *
     * @param request
     * @param response
     */
    public void create(HttpServletRequest request, HttpServletResponse response) {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                Book book = new Book();

                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                String filePath = "";

                for (FileItem fileItem : fileItems) {
                    //若果这个输入项是文件输入
                    if (!fileItem.isFormField() && fileItem != null) {
                        if (fileItem.getName()==null||fileItem.getName().length()==0){
                            continue;
                        }
                        String fieldName = (fileItem.getName());
                        File file = new File(request.getServletContext().getRealPath("/upload/bookImg"));

                        if (!file.exists()){
                            file.mkdirs();
                        }
                        File newFile= new File(file,fieldName);
                        filePath = "upload/bookImg/" + fieldName;
                        fileItem.write(newFile);

                        //若果这个输入项是普通输入
                    } else {
                        //获得属性的名称
                        String fieldName = fileItem.getFieldName();
                        //将属性转化为setXxx形式
                        String setName = "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
                        //遍历book的所有方法
                        Method[] methods = book.getClass().getDeclaredMethods();
                        for (Method method : methods) {
                            //如果方法和setName匹配 则通过set方法为对象赋值
                            if (setName.equals(method.getName())) {
                                Class<?> parameterType = method.getParameterTypes()[0];
                                try {
                                    if (parameterType.getName().equals(BigDecimal.class.getName())) {
                                        //fileItem.getString("UTF-8") 必须参数为"UTF-8 否则会出现乱码问题"
                                        method.invoke(book, new BigDecimal(fileItem.getString("UTF-8")));
                                    } else if (parameterType.getName().equals(String.class.getName())) {
                                        method.invoke(book, fileItem.getString("UTF-8"));
                                    } else if (parameterType.getName().equals(Integer.class.getName())) {
                                        method.invoke(book, Integer.parseInt(fileItem.getString("UTF-8")));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            }
                        }
                    }
                }
                //给对象传入图片的路径
                book.setImgPath(filePath);
                //调用方法添加数据
                bookService.addBook(book);
                //重定向到列表页面
                response.sendRedirect(request.getContextPath() + "/manager/bookServlet?actionMethod=page&pageNo="+request.getParameter("pageNo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("上传的数据有误！");
        }

    }


}
