/**
 * Filename: ButtonPanels.java 
 * Author: vikram Pendyam 
 * Date: 05/09/2019
 * Description: Panel is built and entire sort operation is performed based on
 * the user selection
 * 
*/
package cmsc350project4;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.util.*;

/**
 *
 * Exclusively deals with panels
 */
public class ButtonPanels extends JPanel {

    //FileName label
    private JLabel fileLbl = new JLabel("Input File Name");
    //build graph button label
    private JLabel bgraphlbl = new JLabel(" ");
    //class to recompile label
    private JLabel recompileLbl = new JLabel("Class To Recompile");
    //topsort order button label
    private JLabel tsortlbl = new JLabel(" ");
    //Recompilation order  label
    private JLabel resutlbl = new JLabel("Recompilation Order");
    //bgraph button
    private JButton bgraphBtn = new JButton("Build Directed Graph");
    //topsort button
    private JButton tsortBtn = new JButton("Topological Order");
    //file input text
    private JTextField fileTxt = new JTextField(null, 15);
    //className txt
    private JTextField recompileTxt = new JTextField(15);
    //recompile filename output
    private JTextArea resulTxt = new JTextArea(10, 40);
    JScrollPane scrollPane = new JScrollPane(resulTxt);

    //instantiate the graph class
    Graph g = new Graph();
    //filename
    String fileName;

    public ButtonPanels() {
        setLayout(new GridBagLayout());
        Box panelBox1 = Box.createHorizontalBox();//adding panels into separate boxes
        Box panelBox2 = Box.createHorizontalBox();//adding panels into separate boxes
        panelBox1.add(fileLbl);//file label
        panelBox1.add(fileTxt);// file text area
        panelBox1.add(bgraphlbl);//graph label
        panelBox1.add(bgraphBtn);//build graph button
        panelBox2.add(recompileLbl);//topological sort label
        panelBox2.add(recompileTxt);//topological sort button
        panelBox2.add(tsortlbl);
        panelBox2.add(tsortBtn);//sort button

        addItem(this, panelBox1, 0, 0, 1, 1, GridBagConstraints.WEST);
        addItem(this, panelBox2, 0, 1, 1, 1, GridBagConstraints.WEST);

        Box resultBox = Box.createHorizontalBox();
        resultBox.add(resulTxt);//result text area
        resulTxt.setLineWrap(true);
        resulTxt.setWrapStyleWord(true);
        resulTxt.setEditable(false);
        resulTxt.add(scrollPane);
        resultBox.setBorder(BorderFactory.createTitledBorder("Recompilation Order"));
        addItem(this, resultBox, 0, 2, 1, 1, GridBagConstraints.WEST);

        //handling Build Directed Graph
        bgraphBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileName = fileTxt.getText();
                buildGraph();

            }
        });

        //Topological order button
        tsortBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String output =buildTopSort(recompileTxt.getText());
                resulTxt.setText(output);
            }
        });

    }

    private void buildGraph() {
        try {
            //check to see if fileName is null
            if (fileName.isEmpty()) {
                throw new NullPointerException();
            }
            g.BuildDgraph(fileName);
            JOptionPane.showMessageDialog(null, "Graph Built Successfully", "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NullPointerException e1) {
            JOptionPane.showMessageDialog(null, "Enter fileName" , "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException e2) {
            JOptionPane.showMessageDialog(null, "File did not open", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }catch(Exception e4){
            JOptionPane.showMessageDialog(null, e4, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private String buildTopSort(String className) {
        String output = "";//output of the graph
        try {
            if (className.isEmpty()) {
                throw new NullPointerException();//checking for null pointer exception
            }
            output = g.topologicalSort(className);//calling topological sort
          
        } catch (NullPointerException e1) {
            JOptionPane.showMessageDialog(null, "File did not open" , "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (InvalidClassName e2) {
            JOptionPane.showMessageDialog(null, "Invalid ClassName" , "Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (CycleDetectedException e3) {
            JOptionPane.showMessageDialog(null,e3, "Error",
                    JOptionPane.ERROR_MESSAGE);

        }catch(Exception e4){
            JOptionPane.showMessageDialog(null, e4, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return output;
    }

    /*
     This method is for setting the grid size and field width and height
     */
    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.insets = new Insets(6, 6, 6, 6);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }

}
