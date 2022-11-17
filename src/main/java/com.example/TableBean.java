package com.example;


import java.util.LinkedList;
import java.util.List;

public class TableBean {
    private List<FormBean> table = new LinkedList<>();

    public List<FormBean> getTable() {
        table = HibernateUtils.getAllResults();
        return table;
    }

    public void setTable(List<FormBean> table) {
        this.table = table;
    }
}
