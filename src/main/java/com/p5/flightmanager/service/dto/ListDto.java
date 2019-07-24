package com.p5.flightmanager.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListDto implements Serializable {
    private List<FlightSimpleDto> list = new ArrayList<>();
    private Integer count;

    public List<FlightSimpleDto> getList() {
        return list;
    }

    public void setList(List<FlightSimpleDto> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
