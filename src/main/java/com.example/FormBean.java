package com.example;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.persistence.*;

@Entity
@Table(name="results")
public class FormBean {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="x")
    private double x;

    @Column(name="y")
    private double y;
    @Column(name="r")
    private double r;
    @Column(name="result")
    private Boolean result;

    public FormBean(){

    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void validateY(FacesContext context, UIComponent comp,
                          Object value){
        double cur;
        try{
            cur = Double.parseDouble(value.toString());
        } catch (NumberFormatException e){
            ((UIInput) comp).setValid(false);
            return;
        }
        ((UIInput) comp).setValid(cur >= -3 && cur <= 3);
    }

    public void validateX(FacesContext context, UIComponent comp,
                          Object value){
        double cur;
        try{
            cur = Double.parseDouble(value.toString());
        } catch (NumberFormatException e){
            ((UIInput) comp).setValid(false);
            return;
        }
        ((UIInput) comp).setValid(cur >= -5 && cur <= 5);
    }

    public void validateR(FacesContext context, UIComponent comp,
                          Object value){
        double cur;
        try{
            cur = Double.parseDouble(value.toString());
        } catch (NumberFormatException e){
            ((UIInput) comp).setValid(false);
            return;
        }
        ((UIInput) comp).setValid(cur >= 2 && cur <= 5);
    }

    private boolean checkSquare(double x, double y, double r){
        return x >= -r && x <= 0 && y >= -r && y <= 0;
    }

    private boolean checkQuarterCircle(double x, double y, double r){
        return x >= 0 && y <= 0 && x*x + y*y <= (r / 2) * (r / 2);
    }

    private boolean checkTriangle(double x, double y, double r){
        return x <= 0 && y >= 0 && y - 2 * x <= r;
    }

    private boolean check(double x, double y, double r){
        return checkSquare(x, y, r) || checkQuarterCircle(x, y, r) || checkTriangle(x, y, r);
    }

    public void submit(){
        this.result = check(x, y, r);
        HibernateUtils.addFormBean(this);
        System.out.println(x + " " + y + " " + r + " " + result);
    }
}
