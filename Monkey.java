import java.util.ArrayList;

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
    public Monkey(String name, String species, String gender, String age,
                  String weight, String acquisitionDate, String acquisitionCountry,
                  String trainingStatus, boolean reserved, String inServiceCountry,
                  String bodyLength, String tailLength, String height) {
        super(name, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry);
        setSpecies(species);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setHeight(height);
    }

    //tailLength getter and setter.
    public String getTailLength() {
        return tailLength;
    }

    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    //height getter and setter.
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    //bodyLength getter and setter.
    public String getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    //    species getter and setter.
    public String getSpecies() {
        return species;
    }

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

