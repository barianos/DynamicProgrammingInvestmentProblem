/**
 * Data Structures And Algorithms,
 * Spring 2018
 * Dynamic Programming Project - Investment Problem
 * Anastasios Kristofer Barianos
 */
package gr.teicrete.ie.msc.dynamicprogrammingproject;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Returns Calculator has methods to implement Dynamic Programming calculation
 * of maximum returns for 3 investment options with specific returns value.
 *
 * @author Barianos <Barianos@NiLE>
 */
public class ReturnsCalculator {

    private int OPTIONS = 3;
    private int capital;
    private int[][] max; //max = {r1(d1 +r2(d2) +r3(d3)}
    private int[][] curD; //all values that will be tested
    private int[] maxD; //the values for which returns are maximized
    private float roi;

    /**
     * This constructor acts as an initializer for the calcMaxReturns method
     *
     * @param capital
     */
    public ReturnsCalculator(int capital) {
        this.capital = capital;
        max = new int[capital + 1][OPTIONS];
        curD = new int[capital + 1][OPTIONS];
        maxD = new int[OPTIONS];

        // initialize arrays to -1
        for (int i = 0; i < max.length; i++) {
            Arrays.fill(max[i], -1);
            Arrays.fill(curD[i], -1);
        }
        for (int i = 0; i < maxD.length; i++) {
            Arrays.fill(maxD, -1);
        }
        roi =0;
    }

    /**
     * The core method of the program. Calculates the maximum returns and the
     * capital split for which this occurs.
     *
     * @param option
     * @param availableMoney
     * @return maxReturns
     */
    public int calcMaxReturns(int option, int availableMoney) {
        if (option > OPTIONS) { //recursion escape
            return 0;
        }
        // Skip if we have already computed the value
        if (max[availableMoney][option - 1] != -1) {
            return max[availableMoney][option - 1];
        }

        for (int x = 0; x <= availableMoney; x++) {
            for (int d = 0; d <= x; d++) {
                int curR;  //curent returns value
                if (d == 0) {
                    curR = 0;
                } else {
                    switch (option) {
                        case 1:
                            curR = (7 * d + 2);
                            break;
                        case 2:
                            curR = (3 * d + 7);
                            break;
                        case 3:
                            curR = (4 * d + 5);
                            break;
                        default:
                            curR = 0;
                            break;
                    }
                }
                //recursivelly build our maxReturns
                int totalR = curR + calcMaxReturns(option + 1, x - d);
                //if the calculated returns are better than the previous option
                if (totalR > max[x][option - 1]) {
                    //invest in this option
                    max[x][option - 1] = totalR;
                    curD[x][option - 1] = d;
                }
            }
        }

        // find d that maximizes the equation
        if (availableMoney > 0 && maxD[option - 1] == -1) {
            maxD[option - 1] = curD[availableMoney][option - 1];
        }
        calcROI(max[availableMoney][option - 1]);
        return max[availableMoney][option - 1];
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
     */
    private void calcROI(float returns) {
        roi = (float) (returns - capital) / (float) (capital);
        roi *= 100;
    }
    
    
    
    public int[] getMaxD() {
        return maxD;
    }
    
    public float getROI() {
        return roi;
    }

}
