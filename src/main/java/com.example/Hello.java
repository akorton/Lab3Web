package com.example;

import java.util.Date;

public class Hello {

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        date = new Date();
        return date;
    }
}
