

/**
 * This class creates Dog object for rescue animals
 *
 * @version 0.1.0
 * @since 04-12-2021
 * @author Global Rain
 * @author Michael
 */
public class Dog extends RescueAnimal {
    // Instance variable
    private String breed;

    /**
     *Constructor for Dog Class animal type is set to dog.
     *
     * @param name Name of the animal
     * @param breed Breed of the animal
     * @param gender Gender of the animal
     * @param age age of the animal
     * @param weight Weight of the animal in lbs.
     * @param acquisitionDate Date the animal was acquired.
     * @param acquisitionCountry Name of the country the animal was acquired from.
     * @param trainingStatus Training Status of the animal.
     * @param reserved Reserve status of the rescue animal
     * @param inServiceCountry Service country of the rescue animal i.e United States
     */
    //updated dog and monkey class to inherit super from rescue animal.
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        super(name, gender, age,
                weight,  acquisitionDate,  acquisitionCountry,
                 trainingStatus,  reserved,  inServiceCountry);
        setBreed(breed);
        setAnimalType("dog");
    }

    /**
     * Getter for breed
     *
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Setter for dog  breed
     *
     * @param dogBreed breed of dog
     */
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }


}
