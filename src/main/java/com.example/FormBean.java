package com.example;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class FormBean {
    private double x;
    private double y;
    private double r;
    private boolean result;

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
        System.out.println(x + " " + y + " " + r + " " + result);
    }
}
