 /* File: InfixEvaluator.java
 * Author: Vikram Pendyam
 * Date: Mar 27, 2019
 * Purpose: 
 * This class takes care if inflix to postfix convertion
 */
package stacksweek1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonPanels extends JPanel {

    private JLabel infixLbl = new JLabel("Enter Inflix Expression ");
    private JLabel evalutelbl = new JLabel(" ");
    private JLabel resultlbl = new JLabel("Result");
    private JTextField infixTxt = new JTextField(" ");
    private JTextField resultTxt = new JTextField(" ");
    private JButton evaluteBtn = new JButton("Evaluate");
    InfixEvaluator ev = new InfixEvaluator();

    public ButtonPanels() {
        setLayout(new GridLayout(3, 2));

        add(infixLbl);//label for infix
        add(infixTxt);//text field for infix

        add(evalutelbl);
        add(evaluteBtn);//evalute button

        resultTxt.setEditable(false);
        add(resultlbl);
        add(resultTxt);//result field

        evaluteBtn.addActionListener(new ActionListener() {//handling compute button
            public void actionPerformed(ActionEvent e) {
                evaluate();//calling below method
            }
        });

    }

    public void evaluate() {
        try {
            String infix = infixTxt.getText(); //Infix equation
            if (infix.isEmpty()) {
                throw new NullPointerException();
            } else {
                String result = ev.getResult(infix);
                resultTxt.setText(result);
            }
        } catch (NullPointerException nullValue) {
            JOptionPane.showMessageDialog(null, "Infix Equaltion Required", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (DivideByZero D) {
            JOptionPane.showMessageDialog(null, "Cannot Divide By Zero", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (EmptyStackException es) {
            JOptionPane.showMessageDialog(null, "Invalid Expression", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
