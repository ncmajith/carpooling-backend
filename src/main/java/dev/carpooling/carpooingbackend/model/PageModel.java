package dev.carpooling.carpooingbackend.model;

import java.util.List;

public class PageModel<T> {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    List<T> items;

    public PageModel(Integer pageNumber, Integer pageSize, Integer totalPages, List<T> items) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.items = items;
    }

    public PageModel() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
