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
class Rectangle extends GeometricObject {
    private double width;
    private double height;
    
    public Rectangle(){
        super("blue",true);
        this.height=2.0;
        this.width=2.0;  
    }
    
    public Rectangle(double w,double h,String color,boolean filled){
        super(color,filled);
        this.height=h;
        this.width=w;     
    }
    
    public void setHeight(double h){
        this.height=h;
    }
    
    public void setWidth(double w){
        this.width=w;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double getwidth(){
        return width;
    }
    
    public double getArea(){
        return width*height;
    }
    
    public double getPerimeter(){
        return 2*(width + height);
    }
    
    public String toString(){
        return super.toString()+" Rectangle: Width = " + width +" Height="+ height;
    }
   
}
