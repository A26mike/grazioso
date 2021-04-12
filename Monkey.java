import java.util.ArrayList;

/**
 * This class creates Monkey objects for rescue animals
 *
 * @version 0.1.0
 * @since 04-12-2021
 * @author Michael
 */
public class Monkey extends RescueAnimal {
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    //TODO add monkey species to list
    // Capuchin
    // Guenon
    // Macaque
    // Marmoset
    // Squirrel monkey
    // Tamarin
    // Does this need to be a field

    private ArrayList<Monkey> eligibleSpecies = new ArrayList<>();

    //constructor

    /**
     * Constructor for <code>Monkey</code> Class
     *
     * @param bodyLength body length in inches. Passed to the method <code>setHeight</code>
     * @param tailLength Tail length in inches. Passed to the method <code>setTailLength</code>
     * @param height  height of  in inches. Passed to the method  <code>setHeight</code>
     * @see RescueAnimal
     * @see #setBodyLength(String)
     * @see #setTailLength(String)
     * @see #setHeight(String)
     */
    public Monkey(String name, String species, String gender, String age,
                  String weight, String acquisitionDate, String acquisitionCountry,
                  String trainingStatus, boolean reserved, String inServiceCountry,
                  String bodyLength, String tailLength, String height) {
        //inherits from
        super(name, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry);
        setAnimalType("monkey");
        setSpecies(species);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setHeight(height);
    }

    /**
     * This method is a getter for instance monkeys tail length
     *
     * @bug currently not in use used for future development
     * @return monkeys tail length
     */
    public String getTailLength() {
        return tailLength;
    }

    /**
     * This method is a setter for tail length.
     *
     * @param tailLength tail length in inches
     */
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    /**
     * This method is a getter for height
     *
     * @bug currently not in use used for future development
     * @return height
     */
    public String getHeight() {
        return height;
    }

    /**
     * This method is a setter for height
     *
     * @param height Height in inches
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * This method is a getter for body length
     *
     * @bug currently not in use used for future development
     * @return bodyLength
     */
    public String getBodyLength() {
        return bodyLength;
    }

    /**
     * This method is a setter for body length
     *
     * @param bodyLength Body length in inches
     */
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    /**
     * This method is a getter for species
     *
     * @bug currently not in use used for future development
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * This method is a setter for species
     * <p><ul>
     *      <li>Acceptable species of  monkeys:</li>
     *      <ul>
     *          <li>Capuchin</li>
     *          <li>Guenon</li>
     *          <li>Macaque</li>
     *          <li>Marmoset</li>
     *          <li>Squirrel monkey</li>
     *          <li>Tamarin</li>
     * @param species Species of monkey
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    // eligible species getter and setter place holder not used.
    public ArrayList<Monkey> getEligibleSpecies() {
        return eligibleSpecies;
    }

    public void setEligibleSpecies(ArrayList<Monkey> eligibleSpecies) {
        this.eligibleSpecies = eligibleSpecies;
    }
}

