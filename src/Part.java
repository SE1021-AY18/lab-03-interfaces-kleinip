/**
 * SE1021
 * Isaac Klein
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/16
 */

/**
 * Public Interface for Part objects
 * @author kleinip
 * @version 1.0
 */
public interface Part {

    /**
     * Returns the cost of the part
     * @return cost
     */
    double getCost();

    /**
     * Returns the name
     * @return name
     */
    String getName();

    /**
     * Returns the weight
     * @return weight
     */
    double getWeight();

    /**
     * Prints the correctly formatted output for the part
     */
    void printBillOfMaterials();
}