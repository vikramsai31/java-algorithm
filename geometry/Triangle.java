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

 class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(){
        super("blue",true);
        this.side1=2.0;
        this.side2=2.0;
        this.side3=2.0;
    }
    
    public Triangle(double s1,double s2, double s3,String color,boolean filled){
        super(color,filled);
        this.side1=s1;
        this.side2=s2;
        this.side3=s3;
        
    }
    
    public void setSide1(double s1){
        this.side1=s1;
    }
    
    public void setSide2(double s2){
        this.side1=s2;
    }
     
    public void setSide3(double s3){
        this.side1=s3;
    }
    
    public double getSide1(double s1){
        return side1;
    }
    
    public double getSide2(double s2){
        return side2;
    }
    
    public double getSide3(double s3){
        return side3;
    }
    
    public double getArea(){
        double s;
        s = (side1 + side2 + side3)/2;
        return Math.sqrt(s*((s - side1)*(s - side2)*(s - side3)));     
    }
    
    public double getPerimeter(){
        double p;
        p = side1 + side2 + side3;
        return p;
    }
    
    public String toString(){
        return super.toString()+"Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
    
}
