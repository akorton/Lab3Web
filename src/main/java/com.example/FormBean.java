package com.example;

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
        return checkSquare(x, y, r) && checkQuarterCircle(x, y, r) && checkTriangle(x, y, r);
    }

    public void submit(){
        this.result = check(x, y, r);
        System.out.println(x + " " + y + " " + r + " " + result);
    }
}
