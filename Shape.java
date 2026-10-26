package oop_project;

import java.util.Date;

public abstract class Shape {
    protected Date dateCreated;
    protected String color;
    
    public Shape() {
        this.dateCreated = new Date();
        this.color = "black";
    }
    
    public Shape(String color) {
        this();
        this.color = color;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    @Override
    public String toString() {
        return "Shape [color=" + color + ", dateCreated=" + dateCreated + "]";
    }
}