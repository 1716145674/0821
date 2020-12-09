package com.atguigu.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class TestJspFragment extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment bodyContent = getJspBody();
        //jspFragment.invoke(Writer) 参数为null输出打
        //到页面上
        StringWriter stringWriter = new StringWriter();
        bodyContent.invoke(stringWriter);
        System.out.println(stringWriter.toString());
    }
}
