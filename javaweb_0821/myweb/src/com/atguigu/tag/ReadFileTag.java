package com.atguigu.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ReadFileTag extends SimpleTagSupport {
    private PageContext pageContext;
    private String src;

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println(src);
        pageContext = (PageContext) getJspContext();
        JspWriter out = pageContext.getOut();
        InputStream is = pageContext.getServletContext().getResourceAsStream(src);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = "";
        while ((str = br.readLine()) != null) {
            str= Pattern.compile("<").matcher(str).replaceAll("&lt");
            str=Pattern.compile(">").matcher(str).replaceAll("&gt");
            out.write(str);
            out.write("<br/>");
        }
    }

}
