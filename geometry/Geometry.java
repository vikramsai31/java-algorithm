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
public class Geometry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeometricObject g = new GeometricObject();
        Triangle t = new Triangle();
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        
        System.out.println(g);
        System.out.println(t);
        System.out.println(c);
        System.out.println(r);
        
        System.out.println(t.getArea());
        System.out.println(c.getArea());
        System.out.println(r.getArea());
        
        Triangle t1 = new Triangle(5,5,5,"blue",true);
        Circle c1 = new Circle(5,"blue",true);
        Rectangle r1 = new Rectangle(5,10,"blue",true);
    
        System.out.println(t1.getArea());
        System.out.println(c1.getArea());
        System.out.println(r1.getArea());
        
        System.out.println(t1.getPerimeter());
        System.out.println(c1.getPerimeter());
        System.out.println(r1.getPerimeter());
        
    }
    
}
