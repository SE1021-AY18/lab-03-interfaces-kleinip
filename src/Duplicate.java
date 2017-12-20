/**
 * SE1021
 * Isaac Klein
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/16
 */

import java.text.DecimalFormat;

/**
 * Creates duplicates of a specific object
 * @author kleinip
 * @version 1.0
 */
public class Duplicate implements Part {

    private final DecimalFormat weightFormat = new DecimalFormat("0.###");
    private final DecimalFormat costFormat = new DecimalFormat("$0.00");

    /**
     *Reduction factor for orders over $5
     */
    public static final double REDUCTION_FACTOR1 = 0.95;

    /**
     *Reduction factor for orders over $10
     */
    public static final double REDUCTION_FACTOR2 = 0.9;

    /**
     *Cost threshold used to determine discount
     */
    public static final int USD_THRESHOLD1 = 5;

    /**
     *Cost threshold used to determine discount
     */
    public static final int USD_THRESHOLD2 = 10;
    private Part identicalPart;
    private int numDuplicates;

    /**
     * Default constructor
     * @param numDuplicates number of duplicates to produce
     * @param identicalPart name of the part being duplicated
     */
    public Duplicate(Part identicalPart, int numDuplicates){
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

    /**
     * Returns the cost of the duplicate part
     * @return cost
     */
    public double getCost(){
        if(numDuplicates < USD_THRESHOLD1){
            return identicalPart.getCost() * numDuplicates;
        }else if(numDuplicates < USD_THRESHOLD2){
            return identicalPart.getCost() * REDUCTION_FACTOR1 * numDuplicates;
        }else{
            return identicalPart.getCost() * REDUCTION_FACTOR2 * numDuplicates;
        }
    }

    /**
     * Returns name of the duplicate part
     * @return name
     */
    public String getName(){
        return numDuplicates + " " + identicalPart.getName() + "s";
    }

    /**
     * Returns the total weight
     * @return weight
     */
    public double getWeight(){
        return identicalPart.getWeight() * numDuplicates;
    }

    /**
     * Prints off the correctly formatted output for the assembly
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Duplicate part: " + identicalPart.getName());
        System.out.println("Copies: " + numDuplicates);
        System.out.println("Individual Cost: " + costFormat.format(identicalPart.getCost()));
        System.out.println("Individual Weight: " +
                weightFormat.format(identicalPart.getWeight()) + " lbs");
        System.out.println();
        System.out.println("Total cost: " + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
        identicalPart.printBillOfMaterials();
    }
}