package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.time.LocalDateTime;
import java.util.Date;

@ManagedBean(name="hello")
@RequestScoped
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
