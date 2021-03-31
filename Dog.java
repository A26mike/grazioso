
public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;
    private String animalType = "dog";


    // Constructor
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        super(name, gender, age,
                weight,  acquisitionDate,  acquisitionCountry,
                 trainingStatus,  reserved,  inServiceCountry);

        setBreed(breed);

    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

}
