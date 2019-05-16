/**
 * Filename: ButtonPanels.java A Author: vikram Pendyam Date: 04/18/2019
 * Description: Panel is built and entire sort operation is performed based on
 * the user selection
 * 
*/
package project3cmsc350;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * Exclusively deals with panels
 */
public class ButtonPanels extends JPanel {

    //List label
    private JLabel listLbl = new JLabel("Original List");
    //sort button label
    private JLabel sortlbl = new JLabel(" ");
    //result label
    private JLabel resultlbl = new JLabel("Sorted List");
    //text field for list input
    private JTextField listTxt = new JTextField(30);
    //text field for result output
    private JTextField resultTxt = new JTextField(30);
    //sort button
    private JButton sortBtn = new JButton("Perform Sort");

    //ascending button
    private JRadioButton ascBtn = new JRadioButton("Ascending");
    //descending button
    private JRadioButton descBtn = new JRadioButton("Descending");
    //Integer Radio buton
    private JRadioButton intBtn = new JRadioButton("Integer");
    //Fraction Radio Button
    private JRadioButton fracBtn = new JRadioButton("Fraction");

    public ButtonPanels() {
        setLayout(new GridBagLayout());

        addItem(this, listLbl, 0, 0, 1, 1, GridBagConstraints.EAST);//label for infix
        addItem(this, resultlbl, 0, 2, 1, 1, GridBagConstraints.EAST);

        addItem(this, listTxt, 1, 0, 1, 1, GridBagConstraints.WEST);
        addItem(this, resultTxt, 1, 2, 1, 1, GridBagConstraints.WEST);
        //setting result text as non-editable field
        resultTxt.setEditable(false);
        //setting box for the Sort button
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(sortBtn);
        buttonBox.add(Box.createHorizontalStrut(20));
        addItem(this, buttonBox, 1, 3, 2, 1, GridBagConstraints.WEST);

        //Sort option radio button list
        Box sortBox = Box.createVerticalBox();
        //Grouping the Radio buttopn
        ButtonGroup sortRadioButtons = new ButtonGroup();
        sortRadioButtons.add(ascBtn);
        sortRadioButtons.add(descBtn);

        sortBox.add(ascBtn);
        sortBox.add(descBtn);
        //setting inline border
        sortBox.setBorder(BorderFactory.createTitledBorder("Sort Order"));
        addItem(this, sortBox, 0, 4, 1, 1, GridBagConstraints.NORTH);

        //Numerical type radiobutton
        Box nTypeBox = Box.createVerticalBox();
        ButtonGroup nTypeRadioButtons = new ButtonGroup();
        nTypeRadioButtons.add(intBtn);
        nTypeRadioButtons.add(fracBtn);

        nTypeBox.add(intBtn);
        nTypeBox.add(fracBtn);
        //setting border
        nTypeBox.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
        addItem(this, nTypeBox, 2, 4, 9, 2, GridBagConstraints.NORTH);
        //Ascending option default selected to true
        ascBtn.setSelected(true);
        ascBtn.doClick();
        //Numerical type integer default selected to true
        intBtn.setSelected(true);
        intBtn.doClick();
        //Upon perfrom button click action
        sortBtn.addActionListener(new ActionListener() {//handling compute button
            public void actionPerformed(ActionEvent e) {
                //calling sortedValue method
                resultTxt.setText(sortedValue(listTxt.getText()));
            }
        });

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
        gc.weightx = 200.0;
        gc.weighty = 400.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
    /*
     Sorted string is returned for specified options
     */

    private String sortedValue(String inputValues) {
        String finalResult = "";//initializing the final result value

        try {
            //if the inputValues is empty throw null point exception
            if (inputValues.isEmpty()) {
                throw new NullPointerException();
            }
            //if integer button is selected
            if (intBtn.isSelected()) {
                //Initializing BST class
                Bst tree = new Bst();
                //Converting inputvalues into token integer list
                ArrayList<String> tokens = convertIntArray(inputValues);

                for (int i = 0; i < tokens.size(); i++) {
                    //inserting into binary tree
                    tree.insert(Integer.parseInt(tokens.get(i)));
                }
                //if ascending radio button selected
                if (ascBtn.isSelected()) {
                    int[] array = tree.preOrder(tokens.size());
                    StringBuilder result = new StringBuilder();

                    for (int i = 0; i < array.length; i++) {
                        result.append(array[i]);
                        result.append(" ");
                    }

                    //setting sorted final result
                    finalResult = result.toString();
                    // if decending option is selected
                } else if (descBtn.isSelected()) {
                    //array with desending values
                    int[] array = tree.postOrder(tokens.size());
                    StringBuilder result = new StringBuilder();

                    for (int i = 0; i < array.length; i++) {
                        result.append(array[i]);
                        result.append(" ");
                    }
                    //resultTxt.setText(result.toString());
                    finalResult = result.toString();
                }
// fraction option selected
            } else if (fracBtn.isSelected()) {// numericType=1 is type of input is fraction
                //tokenizing the input values
                ArrayList<SortFractions> frac = new ArrayList<SortFractions>();
                ArrayList<String> farray = convertFracArray(inputValues);

                for (int i = 0; i < farray.size(); i++) {
                    frac.add(new SortFractions(farray.get(i)));
                }
                //ascending button selected
                if (ascBtn.isSelected()) {
                    Collections.sort(frac);//sorting using Collections
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < frac.size(); i++) {
                        result.append(frac.get(i));
                        result.append(" ");
                    }
                    finalResult = result.toString();
                    System.out.println(finalResult);
                } else if (descBtn.isSelected()) {//descending button selected
                    Collections.sort(frac, Collections.reverseOrder());
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < frac.size(); i++) {
                        result.append(frac.get(i));
                        result.append(" ");
                    }
                    finalResult = result.toString();
                    System.out.println(finalResult);

                }

            }

        } catch (NullPointerException e1) {
            JOptionPane.showMessageDialog(null, "Null Values Found->" + e1, "Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Non Numeric Values", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Error Occured->" + e2, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return finalResult;//final sorted result

    }

    /**
     *
     * @param inputValues
     * @return Array list
     */
    private ArrayList<String> convertIntArray(String inputValues) {
        ArrayList<String> tokens = new ArrayList<String>();
        try {

            // trim down the spaces
            inputValues = inputValues.trim();
            char c = inputValues.charAt(0);
            tokens.add(String.valueOf(c));

            for (int i = 1; i < inputValues.length(); i++) {
                c = inputValues.charAt(i);
                char lastc = inputValues.charAt(i - 1);
                if (c == ' ') {
                    continue;//continue is there are any spaces
                }

                if (Character.isDigit(c) && Character.isDigit(lastc)) {
                    tokens.set(tokens.size() - 1, tokens.get((tokens.size() - 1)) + c);//Merging digits if its more than one
                } else {
                    tokens.add(String.valueOf(c));
                }
            }
//exceptions
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Non Numeric Values", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Integer Values" + e, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return tokens;

    }

    /**
     *
     * @param inputValues
     * @return Array list
     */
    private ArrayList<String> convertFracArray(String inputValues) throws MalformedFraction {
        ArrayList<String> tokens = new ArrayList<String>();
        inputValues = inputValues.trim();
        String[] fracValue = inputValues.split(" ");//spliting based on the spaces

        for (int i = 0; i < fracValue.length; i++) {
            String[] chkFrac = fracValue[i].split("/");
            if (chkFrac.length != 2 || !chkFrac[0].matches("\\d+") || !chkFrac[1].matches("\\d+") || chkFrac[1] == "0") {
                //raise exception if its not digit or array greater than 2 or dividing numerator by 0
                throw new MalformedFraction("Non Numeric Values");
            } else {

                tokens.add(fracValue[i]);
            }
        }

        return tokens;//return array list
    }

}
