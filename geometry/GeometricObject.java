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
public class GeometricObject {
    private String color;
    private boolean filled;
    
    public GeometricObject(String color,boolean filled){
        this.color=color;
        this.filled=filled;
    }
    
    public GeometricObject(){
        this.filled=false;
        this.color="red";
    }
    
    public void setColor(String color){
        this.color=color;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setFilled(boolean filled){
        this.filled=filled;
    }
    
    public boolean getFilled(){
        return filled;
    }
    
    public String toString(){
        return "Object is filled with "+color+" "+filled;
    }
    
    
}
