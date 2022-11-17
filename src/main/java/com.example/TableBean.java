package com.example;


import java.util.LinkedList;
import java.util.List;

public class TableBean {
    private List<FormBean> table = new LinkedList<>();
    private String serializedTable;

    public List<FormBean> getTable() {
        table = HibernateUtils.getAllResults();
        return table;
    }

    public void setTable(List<FormBean> table) {
        this.table = table;
    }

    public String getSerializedTable() {
        serializedTable = HibernateUtils.getAllResultsJson();
        return serializedTable;
    }

    public void setSerializedTable(String serializedTable) {
        this.serializedTable = serializedTable;
    }
}
