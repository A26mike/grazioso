import java.util.ArrayList;

/*TODO Create a Monkey Class that:
        Inherits from the RescueAnimal class
        Includes monkey-specific attributes
        Includes mutator and accessor methods for each attribute
        */

public class Monkey extends RescueAnimal{

    private Double tailLength;
    private Double height;
    private double bodyLength;
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

    /*
    private String name;
    private String animalType;
    private String gender;
    private String age;
    private String weight;
    private String acquisitionDate;
    private String acquisitionCountry;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceCountry;
    */

    //TODO define better constructor.

    public Monkey(String name, String species, String gender, String age,
               String weight, String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }

    //tailLength getter and setter.
    public Double getTailLength() {
        return tailLength;
    }

    public void setTailLength(Double tailLength) {
        this.tailLength = tailLength;
    }

    //height getter and setter.
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    //bodyLength getter and setter.
    public Double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(Double bodyLength) {
        this.bodyLength = bodyLength;
    }

    //    species getter and setter.

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // eligible species getter and setter
    public ArrayList<Monkey> getEligibleSpecies() {
        return eligibleSpecies;
    }

    public void setEligibleSpecies(ArrayList<Monkey> eligibleSpecies) {
        this.eligibleSpecies = eligibleSpecies;
    }
}

