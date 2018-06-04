/**
 * Data Structures And Algorithms,
 * Spring 2018
 * Dynamic Programming Project - Investment Problem
 * Anastasios Kristofer Barianos
 */
package gr.teicrete.ie.msc.dynamicprogrammingproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * A class that handles the GUI part of the software
 *
 * @author Barianos <Barianos@NiLE>
 */
public class GUIFrame extends JFrame implements ActionListener {

    JPanel motherPanel;
    JPanel fatherPanel;
    JPanel basicPanel;
    JPanel inputPanel;
    JPanel resultsPanel;

    //input panel fields
    JLabel welcomeLabel;
    JLabel sumLabel;
    JButton okButton;
    JTextField inputSum;

    //result panel fields
    //labels
    JLabel resultsLabel;
    JLabel comboLabel;
    JLabel r1Label;
    JLabel r2Label;
    JLabel r3Label;
    JLabel profitLabel;
    JLabel roiLabel;
    //values
    JTextArea roiValue;
    JTextArea resultValue;
    JTextArea profitValue;
    JTextArea comboValue;
    JTextArea r1Value;
    JTextArea r2Value;
    JTextArea r3Value;

    public GUIFrame(String title) {
        super(title);
        initInputComponents();
    }

    private void initInputComponents() {

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        motherPanel = new JPanel(new BorderLayout());
        fatherPanel = new JPanel(new BorderLayout());
        basicPanel = new JPanel();
        inputPanel = new JPanel(new FlowLayout());
        welcomeLabel = new JLabel("Welcome to investment calculator!",
                SwingConstants.CENTER);
        sumLabel = new JLabel("Investment Capital: ", SwingConstants.CENTER);

        inputSum = new JTextField();
        inputSum.setFont(inputSum.getFont().deriveFont(18f));
        inputSum.setPreferredSize(new Dimension(100, 24));

        okButton = new JButton("Calculate");
        okButton.addActionListener(this);

        basicPanel.setLayout(new GridLayout(3, 2));
        basicPanel.add(sumLabel);
        basicPanel.add(inputPanel);
        basicPanel.add(new JLabel());
        inputPanel.add(inputSum);
        inputPanel.add(okButton);
        basicPanel.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        motherPanel.add(welcomeLabel, BorderLayout.NORTH);
        motherPanel.add(basicPanel, BorderLayout.SOUTH);
        motherPanel.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        add(motherPanel, BorderLayout.NORTH);

        comboLabel = new JLabel("Investment split: ", SwingConstants.RIGHT);
        comboValue = new JTextArea();
        comboValue.setFont(comboValue.getFont().deriveFont(24f));
        comboValue.setEditable(false);
        comboValue.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        r1Label = new JLabel("Amount to invest in option 1: ", SwingConstants.RIGHT);
        r2Label = new JLabel("Amount to invest in option 2: ", SwingConstants.RIGHT);
        r3Label = new JLabel("Amount to invest in option 3: ", SwingConstants.RIGHT);

        r1Value = new JTextArea();
        r1Value.setFont(r1Value.getFont().deriveFont(24f));
        r1Value.setEditable(false);
        r1Value.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        r2Value = new JTextArea();
        r2Value.setFont(r2Value.getFont().deriveFont(24f));
        r2Value.setEditable(false);
        r2Value.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        r3Value = new JTextArea();
        r3Value.setFont(r3Value.getFont().deriveFont(24f));
        r3Value.setEditable(false);
        r3Value.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        resultsPanel = new JPanel(new GridLayout(7, 2));
        resultsLabel = new JLabel("Maximum returns attainable: ",
                SwingConstants.RIGHT);
        resultValue = new JTextArea();
        resultValue.setEditable(false);
        resultValue.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        resultValue.setFont(resultValue.getFont().deriveFont(24f));

        profitLabel = new JLabel("Net profit: ", SwingConstants.RIGHT);
        profitValue = new JTextArea();
        profitValue = new JTextArea();
        profitValue.setFont(profitValue.getFont().deriveFont(18f));
        profitValue.setForeground(Color.GREEN);
        profitValue.setEditable(false);
        profitValue.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        roiLabel = new JLabel("Return on Investment: ", SwingConstants.RIGHT);
        roiValue = new JTextArea();
        roiValue.setFont(roiValue.getFont().deriveFont(24f));
        roiValue.setEditable(false);
        roiValue.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        resultsPanel.add(comboLabel);
        resultsPanel.add(comboValue);
        resultsPanel.add(r1Label);
        resultsPanel.add(r1Value);
        resultsPanel.add(r2Label);
        resultsPanel.add(r2Value);
        resultsPanel.add(r3Label);
        resultsPanel.add(r3Value);
        resultsPanel.add(resultsLabel);
        resultsPanel.add(resultValue);
        resultsPanel.add(profitLabel);
        resultsPanel.add(profitValue);
        resultsPanel.add(roiLabel);
        resultsPanel.add(roiValue);
        resultsPanel.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        fatherPanel.add(resultsPanel, BorderLayout.CENTER);
        fatherPanel.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        add(fatherPanel, BorderLayout.CENTER);
        JLabel signature = new JLabel("Barianos Kristofer Anastasios - MTP179",
                SwingConstants.CENTER);

        add(signature, BorderLayout.SOUTH);

    }

    /**
     * Updates JLabels with updates values for the last query
     *
     * @param capital
     * @param returns
     * @param combo
     */
    private void updateResults(int capital, int returns, int[] combo, float roi) {
        //do calculations
        returns *= 10000;
        capital *= 10000;
        String roiString = formatROI(roi);

        //update values
        comboValue.setText(Integer.toString(combo[0]) + " - "
                + Integer.toString(combo[1]) + " - "
                + Integer.toString(combo[2]));
        r1Value.setText(Integer.toString(combo[0] * 10000) + " \u20ac");
        r2Value.setText(Integer.toString(combo[1] * 10000) + " \u20ac");
        r3Value.setText(Integer.toString(combo[2] * 10000) + " \u20ac");
        resultValue.setText(Integer.toString(returns) + " \u20ac");
        profitValue.setText(Integer.toString(returns - capital) + " \u20ac");
        roiValue.setText(formatROI(roi) + "%");

        //refresh the frame
        invalidate();
        validate();
        repaint();

    }

    
    /*
    Return on Investment (ROI) is a performance measure, used to evaluate the 
    efficiency of an investment or compare the efficiency of a number of 
    different investments. ROI measures the amount of return on an investment, 
    relative to the investment’s cost. To calculate ROI, the benefit (or return)
    of an investment is divided by the cost of the investment. The result is 
    expressed as a percentage or a ratio.
     */
    /**
     * Utility method that calculates Return on Investment as percentage
     *
     * @param returns
     * @param capital
     * @return roi as string
     */
    private String formatROI(float roi) {
        DecimalFormat dc = new DecimalFormat("0.00");
        return dc.format(roi);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputSum.getText();

        if (Pattern.matches("\\d+", input)) { //check that input is integer
            int invSum = Integer.parseInt(input);
            if (invSum >= 30000) {
                invSum /= 10000; //divide by 10000 to make caclulations faster
                ReturnsCalculator rC = new ReturnsCalculator(invSum);
                //find max returns
                int maxReturns = rC.calcMaxReturns(1, invSum);
                //get best invesment split
                int[] maxCombo = rC.getMaxD();
                float roi = rC.getROI();
                ///show results on GUI
                updateResults(invSum, maxReturns, maxCombo, roi);
            } else {
                JOptionPane.showMessageDialog(new JFrame("Error!"),
                        "Input must be in tens of thousands and at least 30000", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame("Error!"),
                    "Input must be an integer number!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
