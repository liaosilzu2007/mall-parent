package com.lzumetal.mall.common.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author liaosi
 * @date 2018-09-02
 */
public class PageBean<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 指定的或是页面参数
    private long pageNo; // 当前页
    private int pageSize; // 每页显示多少条

    // 查询数据库
    private long pageCount; //总页数
    private long totalCount; // 总记录数
    private List<E> data; // 本页的数据列表

    //是否有上一页
    private boolean hasPrevious = false;
    //是否有下一页
    private boolean hasNext = false;


    public PageBean(int pageNo, int pageSize, long totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.pageCount = getTotalPageCount();
        refresh();
    }

    /**
     * 构造器
     */
    public PageBean(int pageNo, int pageSize, long totalCount, List<E> data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.pageCount = getTotalPageCount();
        this.data = data;
        refresh();
    }

    /**
     * 计算总页数
     */
    private long getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    /**
     * 刷新当前分页对象数据
     */
    private void refresh() {
        if (pageCount <= 1) {
            hasPrevious = false;
            hasNext = false;
        } else if (pageNo == 1) {
            hasPrevious = false;
            hasNext = true;
        } else if (pageNo == pageCount) {
            hasPrevious = true;
            hasNext = false;
        } else {
            hasPrevious = true;
            hasNext = true;
        }
    }


    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }


}
