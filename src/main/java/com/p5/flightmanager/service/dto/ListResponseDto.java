package com.p5.flightmanager.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListResponseDto<T> implements Serializable {

    private List<T> list = new ArrayList<>();
    private Long totalCount = 0l;

    public ListResponseDto() {
    }

    public ListResponseDto(List<T> list, Long totalCount) {
        this.list = list;
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
