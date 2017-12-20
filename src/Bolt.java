/**
 * SE1021
 * Isaac Klein
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/16
 */

import java.text.DecimalFormat;

/**
 * Bolt Part
 * @author kleinip
 * @version 1.0
 */
public class Bolt implements Part{

    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.###");

    /**
     *Multiplier used to calculate weight in  pounds
     */
    public static final double LBS_MULTIPLIER = 0.05;

    /**
     *Multiplier used in calculating price in USD
     */
    public static final double USD_MULTIPLIER = 1.00;
    private double diameterInches;
    private double lengthInches;

    /**
     * Default constructor
     * @param diameterInches Diameter of bolt
     * @param lengthInches Length of bolt
     */
    public Bolt(double diameterInches, double lengthInches){
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    /**
     * Returns the name of the part
     * @return name of bolt
     */
    public String getName(){
        return diameterInches + "x" + lengthInches + " bolt";
    }

    /**
     * Returns the cost of the part
     * @return cost of the bolt
     */
    public double getCost(){
        return USD_MULTIPLIER * diameterInches * lengthInches;
    }

    /**
     * Returns the weight of the part
     * @return weight of the bolt
     */
    public double getWeight(){
        return LBS_MULTIPLIER * (diameterInches * diameterInches) * lengthInches;
    }

    /**
     * Prints the bolt output correctly formatted
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
    }
}



