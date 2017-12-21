/*
 * SE1021
 * Isaac Klein
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/16
 */

import java.text.DecimalFormat;

/**
 * Nut Object
 * @author kleinip
 * @version 1.0
 */
public class Nut implements Part {

    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.###");
    private double diameterInches;
    /**
     * Multiplier used to calculate total weight in pounds
     */
    public static final double LBS_MULTIPLIER = 0.01;
    /**
     *Multiplier used to calculate price in USD
     */
    public static final double USD_MULTIPLIER = 0.5;

    /**
     * Default constructor
     * @param diameterInches diameter in inches
     */
    public Nut(double diameterInches){
        this.diameterInches = diameterInches;
    }

    /**
     * Returns the cost of each nut
     * @return cost
     */
    public double getCost(){
        return USD_MULTIPLIER * diameterInches;
    }

    /**
     * Returns the name of the nut
     * @return name
     */
    public String getName(){
        return diameterInches + " inch nut";
    }

    /**
     * Returns the weight of the nut
     * @return weight
     */
    public double getWeight(){
        return LBS_MULTIPLIER * (diameterInches * diameterInches);
    }

    /**
     * Prints off the correctly formatted output
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
    }
}



