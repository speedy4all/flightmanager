package com.p5.flightmanager.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListDto<FlightDtoView> implements Serializable {

    private List<FlightDtoView> objects = new ArrayList();
    private Long count = 0L;

    public ListDto() {

    }

    public ListDto(List<FlightDtoView> objects, Long count) {
        this.objects = objects;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getObjects() {
        return objects;
    }

    public void setObjects(List objects) {
        this.objects = objects;
    }
}
