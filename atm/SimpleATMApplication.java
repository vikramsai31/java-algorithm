/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author vpendyam
 */
import java.awt.*;
public class SimpleATMApplication extends NiceFrame{
    public SimpleATMApplication(){
        super("ATM Application", 300,200);
        add(new SimpleATMPanel());
    }
    
    
}



