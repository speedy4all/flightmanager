package com.p5.flightmanager.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListDto implements Serializable {

    private List objects = new ArrayList();
    private Long count = 0L;

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
