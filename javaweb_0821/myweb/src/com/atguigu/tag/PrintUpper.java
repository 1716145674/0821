package com.atguigu.tag;

import javax.lang.model.element.NestingKind;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;
import java.io.IOException;
import java.io.StringWriter;

public class PrintUpper extends SimpleTagSupport {
    private PageContext pageContext;
    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void doTag() throws JspException, IOException {
        this.pageContext = (PageContext) getJspContext();
        JspFragment bodyContent = getJspBody();

        StringWriter sw = new StringWriter();
        //得到标签体的内容
        bodyContent.invoke(sw);

        String content =sw.toString().toUpperCase();

        int timeValue=0;
        try {
            timeValue=Integer.parseInt(time);
            for (int i = 0; i < timeValue; i++) {
                pageContext.getOut().write((i+1)+":"+content+"<br/>");
            }
        }catch (Exception e){

        }

    }
}
