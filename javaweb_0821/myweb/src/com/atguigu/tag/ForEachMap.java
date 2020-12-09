package com.atguigu.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ForEachMap extends SimpleTagSupport {
    private PageContext pageContext;
    private Map<?,?> items;
    private  String var;

    public void setItems(Map<?, ?> items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        pageContext= (PageContext) getJspContext();
        if (items!=null){
            Set<? extends Map.Entry<?, ?>> entries =items.entrySet();
            for (Map.Entry<?, ?> entry : entries) {
                pageContext.setAttribute(var,entry);
                getJspBody().invoke(null);
            }
        }
    }
}
