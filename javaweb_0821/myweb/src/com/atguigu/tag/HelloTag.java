package com.atguigu.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HelloTag implements SimpleTag {
    private PageContext pageContext;
    private String value;
    private String count;

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = pageContext.getOut();
        int  a=0;
        a=Integer.parseInt(count);
        for (int i = 0; i < a; i++) {
            out.print((i+1)+":"+value);
            out.print("<br/>");
        }
    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
            pageContext = (PageContext) jspContext;

    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}
