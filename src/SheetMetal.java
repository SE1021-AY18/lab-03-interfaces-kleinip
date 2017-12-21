/**
 * SE1021
 * Isaac Klein
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/16
 */

import java.text.DecimalFormat;

/**
 * Sheet Metal Object
 * @author kleinip
 * @version 1.0
 */
public class SheetMetal implements Part {

    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.###");

    /**
     * Multiplier used to calculate weight in pounds
     */
    public static final double LBS_MULTIPLIER = 0.1;

    /**
     *Multiplier used to calculate price in USD
     */
    public static final double USD_MULTIPLIER = 0.5;
    private double thicknessInches;
    private double lengthInches;
    private double widthInches;

    /**
     * Default Constructor
     * @param lengthInches Length
     * @param widthInches Width
     * @param thicknessInches Height
     */
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches){
        this.thicknessInches = thicknessInches;
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
    }

    /**
     * Returns the cost of the sheet metal
     * @return cost
     */
    public double getCost(){
        return USD_MULTIPLIER * thicknessInches * lengthInches * widthInches;
    }

    /**
     * Returns the weight of the sheet metal
     * @return weight
     */
    public double getWeight(){
        return LBS_MULTIPLIER * thicknessInches * lengthInches * widthInches;
    }

    /**
     * Returns the name of the sheet metal
     * @return name
     */
    public String getName(){
        return lengthInches + "x" + widthInches + "x" + thicknessInches + " sheet";
    }

    /**
     * Prints the correctly formatted output
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Width: " + widthInches + " inches");
        System.out.println("Thickness " + thicknessInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
    }
}