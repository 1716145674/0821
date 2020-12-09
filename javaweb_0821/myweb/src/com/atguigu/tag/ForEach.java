package com.atguigu.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;

public class ForEach extends SimpleTagSupport {
  private PageContext pageContext;
  private Collection<?> items;

  private String var;
  public void setItems(Collection<?> items){
      this.items=items;
  }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        pageContext= (PageContext) getJspContext();
        if (items!=null){
            for (Object item : items) {
                pageContext.setAttribute(var,item);
                getJspBody().invoke(null);
            }
        }
    }
}
