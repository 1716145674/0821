package com.atguigu.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ForEachAll extends SimpleTagSupport {
    private PageContext pageContext;
    private Object items;

    private String var;

    public void setItems(Object items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        pageContext = (PageContext) getJspContext();
        if (items != null) {
            if (items instanceof Collection) {
                Collection<?> itemsTemp = (Collection<?>) items;
                for (Object item : itemsTemp) {
                    pageContext.setAttribute(var, item);
                    getJspBody().invoke(null);
                }
            }
            if (items instanceof Map){
                Map<?,?> map= (Map<?, ?>) items;
                Set<? extends Map.Entry<?, ?>> entries =map.entrySet();
                for (Map.Entry<?, ?> entry : entries) {
                    pageContext.setAttribute(var,entry);
                    getJspBody().invoke(null);
                }
            }
        }
    }
}
