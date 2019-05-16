/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 *
 * @author vpendyam
 */
import java.math.*;
 class Circle extends GeometricObject{
    private double radius;
    public Circle(){
        super("blue",true);
        this.radius =2.0;
    }
    
    public Circle(double r,String color,boolean filled){
        super(color,filled);
        this.radius =r;
    }
    
    public void setRadius(double r){
        this.radius=r;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    
    public String toString(){
        return super.toString()+" Circle: Radius = " + radius ;
    }
    
}
