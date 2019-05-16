/**
 * Filename: ButtonPanels.java Author: vikram Pendyam Date: 04/08/2019
 * Description: BuildingGUI componments within the frame
 */
package P2GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonPanels extends JPanel {

    private JLabel postfixLbl = new JLabel("Enter Postfix Expression ");
    private JLabel evalutelbl = new JLabel(" ");
    private JLabel resultlbl = new JLabel("Infix Expression");
    private JTextField postfixTxt = new JTextField(" ");
    private JTextField resultTxt = new JTextField(" ");
    private JButton evaluteBtn = new JButton("Construct Tree");
    PostfixToInfix ev = new PostfixToInfix();

    public ButtonPanels() {
        setLayout(new GridLayout(3, 2));

        add(postfixLbl);//label for infix
        add(postfixTxt);//text field for infix

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

    /*
     *Where postfix expression is evaluated and all exceptions are caught
     */
    public void evaluate() {
        try {
            String postfix = postfixTxt.getText(); //Postfix equation
            if (postfix.isEmpty()) {
                throw new NullPointerException();
            } else {
                String result = ev.evaluate(postfix);
                resultTxt.setText(result);
            }
        } catch (NullPointerException nullValue) {
            JOptionPane.showMessageDialog(null, "PostFix Equation Required", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (InvalidExpression ie) {
            JOptionPane.showMessageDialog(null, "Invalid Token "+ ie, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (EmptyStackException es) {
            JOptionPane.showMessageDialog(null, "Invalid Expression" + es, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
