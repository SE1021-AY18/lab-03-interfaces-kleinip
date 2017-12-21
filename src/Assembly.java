/**
 * SE1021
 * Isaac Klein
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/16
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Creates an assembly of different parts that work together
 * @author kleinip
 * @version 1.0
 */
public class Assembly implements Part {

    /**
     *Fee in USD per part in the assembly
     */
    public static final double USD_PER_SUB_PART = 0.25;
    private final DecimalFormat weightFormat = new DecimalFormat("0.###");
    private final DecimalFormat costFormat = new DecimalFormat("$0.00");
    private ArrayList<Part> subParts = new ArrayList();
    private String name;

    /**
     * Default Constructor
     * @param name Name of the assembly
     */
    public Assembly(String name){
        this.name = name;
    }

    /**
     * adds a new Part to the arraylist
     * @param part New part that was added
     */
    public void addPart(Part part){
        subParts.add(part);
    }

    /**
     * Returns the cost of the assembly
     * @return cost
     */
    public double getCost(){
        double cost = subParts.size() * USD_PER_SUB_PART;  //Adds the fee for number of parts
        for(Part part : subParts){
            cost += part.getCost();  //Adds on every cost for each part of the assembly
        }
        return cost;
    }

    /**
     * Returns the name of the assembly
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the weight of the assembly
     * @return weight
     */
    public double getWeight(){
        double weight = 0;
        for(Part part : subParts){
            weight += part.getWeight();
        }
        return weight;
    }

    /**
     * Prints the correctly formatted output for the assembly
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");

        for(Part part : subParts){
            System.out.println("Part: " + part.getName());
            System.out.println("Cost: " + costFormat.format(part.getCost()));
            System.out.println("Weight: " + weightFormat.format(part.getWeight()) + " lbs");
            System.out.println();
        }

        System.out.println("Total cost: " + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();

        for(Part part : subParts){
            part.printBillOfMaterials();
        }
    }
}




