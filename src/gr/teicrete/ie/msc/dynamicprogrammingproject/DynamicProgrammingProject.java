/**
 * Data Structures And Algorithms,
 * Spring 2018
 * Dynamic Programming Project - Investment Problem
 * Anastasios Kristofer Barianos
 */
//You are asked to design and implement, in any programming language you are 
//more comfortable with, a solution to the following problem:
//Assuming you have N tens of thousands of euro to invest (all amounts in the 
//problem are integers representing tens of thousands), you have to decide how to 
//split that amount in investing in three different investment products. If you 
//decide to invest di (tens of thousands of euros) in investment product i, your 
//profit will be r(di), where:
//r1(d1) = (7* d1 + 2) * 10
//r2(d2) = (3* d2 + 7) * 10
//r3(d3) = (4* d3 + 5) * 10
//for di>0 and r1(0) = r2(0) = r3(0) = 0.
//You are asked to find the amount you must invest in each product so as to 
//maximize the total profit of all investments.
//This problem can be modeled as a dynamic programming problem in the 
//following fashion:
//max (r1(d1) + r2(d2) + r3(d3))
//given that: d1 + d2 + d3 <= N
package gr.teicrete.ie.msc.dynamicprogrammingproject;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Barianos <Barianos@NiLE>
 */
public class DynamicProgrammingProject {

    /**
     * this main method creates a GUIFrame which then drives the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIFrame frame = new GUIFrame("Dynamic Programing Project, Spring 2018");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();

    }
}
