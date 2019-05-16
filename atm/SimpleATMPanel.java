
package atm;

 /* File: SimpleATMPanel.java
 * Author: Vikram Pendyam
 * Date: Feb 8, 2019
 * Purpose: This class which calls the buttons and panle
 * 
 */
import java.awt.*;
import javax.swing.*;
public class SimpleATMPanel extends JPanel {
    public InOutPanel ioPanel = new InOutPanel(this);
    public ButtonsPanel btnPanel = new ButtonsPanel(this);
    
      public SimpleATMPanel () {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        add(btnPanel, BorderLayout.CENTER);
        add(ioPanel, BorderLayout.SOUTH);
        
    }
    
}
