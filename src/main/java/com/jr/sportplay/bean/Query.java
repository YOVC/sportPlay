package com.jr.sportplay.bean;

import lombok.Data;

@Data
public class Query {
    private String username;
    private int pageSize;
    private int pageStart;

    public Query() {
    }

    public Query(String username, int pageSize, int pageStart) {
        this.username = username;
        this.pageSize = pageSize;
        this.pageStart = pageStart;
    }
}
