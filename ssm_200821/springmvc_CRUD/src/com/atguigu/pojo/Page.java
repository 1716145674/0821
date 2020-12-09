package com.atguigu.pojo;

import java.util.List;

public class Page<T> {
    //每页的记录数
    public static final Integer PAGE_SIZE = 5;
    //当前页面
    private Integer pageNo;
    //总共的记录数
    private Integer pageTotal;
    //总的页面数
    private Integer pageCount;
    //每页显示的记录数
    private Integer pageSize = PAGE_SIZE;
    //每页显示的记录
    private List<T> items;
    //url
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageCount, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo<1){
            this.pageNo=1;
        }else if(pageNo >pageCount) {
            this.pageNo=pageCount;
        }else {
            this.pageNo = pageNo;
        }

    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize<=0){
        }else
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
