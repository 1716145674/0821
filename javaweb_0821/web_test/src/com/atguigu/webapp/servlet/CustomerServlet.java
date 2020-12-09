package com.atguigu.webapp.servlet;

import com.atguigu.webapp.beans.Customer;
import com.atguigu.webapp.criteria.CriteriaCustomer;
import com.atguigu.webapp.dao.CustomerDao;
import com.atguigu.webapp.daoimpl.CustomerDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class CustomerServlet extends BaseServlet {
    CustomerDao customerDao;

    public CustomerServlet() {
        customerDao = new CustomerDaoImpl();
    }

    public void addCustomer(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        if (customerDao.getCountByName(name) != 0) {
            request.setAttribute("message", name + "已存在！请重新输入用户名");
            try {
                request.getRequestDispatcher("/newCustomer.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Customer cust = new Customer(name, address, phone);
        customerDao.save(cust);
        try {
            response.sendRedirect("addSuccess.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void query(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        CriteriaCustomer criteriaCustomer = new CriteriaCustomer(name, address, phone);

        List<Customer> customers = customerDao.getListForCriteriaCustomer(criteriaCustomer);
        request.setAttribute("customers", customers);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }
        customerDao.delete(id);
        try {
            response.sendRedirect("query.do");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void showOldCustomer(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
            Customer oldCustomer = customerDao.get(id);
            request.setAttribute("oldCustomer", oldCustomer);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (Exception e) {
            return;
        }
    }
    public void showOldCustomer_1(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
            Customer oldCustomer = customerDao.get(id);
            request.setAttribute("oldCustomer", oldCustomer);
            request.getRequestDispatcher("/update_1.jsp").forward(request, response);
        } catch (Exception e) {
            return;
        }
    }

    public void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String oldName = request.getParameter("oldName");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Customer customer=null;
        if (oldName.equalsIgnoreCase(name)) {
            customer=new Customer(id,name,address,phone);
            customerDao.update(customer);
            try {
                response.sendRedirect("update_succ.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (customerDao.getCountByName(name) > 0) {
                request.setAttribute("message", "用户名" + name + "已存在请重新输入");
                customer=new Customer(id,oldName,address,phone);
                request.setAttribute("newCustomer",customer);
                try {
                    request.getRequestDispatcher("/showOldCustomer.do?id=" + id).forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            } else {
                customer=new Customer(id,name,address,phone);
                customerDao.update(customer);
                try {
                    response.sendRedirect("update_succ.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void updateCustomer_1(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String oldName = request.getParameter("oldName");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Customer customer=null;
        if (oldName.equalsIgnoreCase(name)) {
            customer=new Customer(id,name,address,phone);
            customerDao.update(customer);
            try {
                response.sendRedirect("update_succ.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (customerDao.getCountByName(name) > 0) {
                request.setAttribute("message", "用户名" + name + "已存在请重新输入");
                customer=new Customer(id,oldName,address,phone);
                request.setAttribute("newCustomer",customer);
                try {
                    request.getRequestDispatcher("/showOldCustomer_1.do?id=" + id).forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            } else {
                customer=new Customer(id,name,address,phone);
                customerDao.update(customer);
                try {
                    response.sendRedirect("update_succ.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
