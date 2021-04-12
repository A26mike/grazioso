import java.lang.String;

// changed to abstract class
// cant make an object out of abstract class.

/**
 * This class abstract class for Monkey and dog class. Can not be used to create an object
 * used to as a return type in the Driver class
 *
 * @see Dog
 * @see Monkey
 * @version 0.1.0
 * @since 04-12-2021
 * @author Michael
 * @author Global Rain
 */
public abstract class RescueAnimal {

    // Instance variables
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

	/**
	 * Constructor for abstract class <code>RescueAnimal</code>.
	 *
	 * @param name Name of the animal
	 * @param gender Gender of the animal
	 * @param age age of the animal
	 * @param weight Weight of the animal in lbs.
	 * @param acquisitionDate Date the animal was acquired.
	 * @param acquisitionCountry Name of the country the animal was acquired from.
	 * @param trainingStatus Training Status of the animal.
	 * @param reserved Reserve status of the rescue animal
	 * @param inServiceCountry Service country of the rescue animal i.e United States
	 */
    public RescueAnimal(String name, String gender, String age,
						String weight, String acquisitionDate, String acquisitionCountry,
						String trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);

	}

	/**
	 * This method is a getter for name
	 *
	 * @return name of the object animal
	 * @bug Not in uses place holder for future use.
	 * @see #RescueAnimal(String, String, String, String, String, String, String, boolean, String) 
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is a setter for name
	 *
	 * @param name name of animal
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is a getter for 
	 * 
	 * @bug Not in uses place holder for future use.
	 * @return animal type
	 */
	public String getAnimalType() {
		return animalType;
	}

	/**
	 * This method is a setter for animal type
	 *
	 * @param animalType type of animal dog or monkey
	 */
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	/**
	 * This method is a getter for animal gender
	 *
	 * @return gender of the animal.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method is a setter for animal gender
	 *
	 * @param gender gender of animal.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This method is a getter for animal age
	 *
	 * @bug method not in use for the future.
	 * @return animal age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * This method is a setter for animal age
	 *
	 * @param age animal age in years.
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * This is a getter for animal weight
	 *
	 * @return animal weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * This method is a setter for animal weight.
	 *
	 * @param weight weight of animal in lbs
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * This method is a getter for animal acquisition date
	 *
	 * @return date of acquisition
	 */
	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	/**
	 * This method is a setter for acquisition date
	 *
	 * @param acquisitionDate date of acquisition for animal
	 */
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	/**
	 * This method is a getter for animal acquisition location
	 *
	 * @return date of acquisition
	 */
	public String getAcquisitionLocation() {
		return acquisitionCountry;
	}

	/**
	 * This method is a setter for acquisition country
	 *
	 * @param acquisitionCountry acquisition country  for animal
	 */
	public void setAcquisitionLocation(String acquisitionCountry) {
		this.acquisitionCountry = acquisitionCountry;
	}

	/**
	 *This method is a getter for to check if an animal is reserved
	 *
	 * @return animals reserve status
	 */
	public boolean getReserved() {
		return reserved;
	}

	/**
	 * This method sets the reserve status of an animal
	 * <p>

	 * @param reserved true or false
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	/**
	 * This method gets the in service location
	 *
	 * @return service location
	 */
	public String getInServiceLocation() {
		return inServiceCountry;
	}

	/**
	 * Setter for service location
	 *
	 * @param inServiceCountry location the animal is working
	 */
	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}

	/**
	 * getter for service location
	 *
	 * @return the animals training status
	 */
	public String getTrainingStatus() {
		return trainingStatus;
	}

	/**
	 * This method sets the reserve status
	 * <p>
	 *      In current operations, dogs are given the status
	 * of “intake” before training starts. Once in training, their status can change to one of five phases:
	 * Phase I, Phase II, Phase III, Phase IV, and Phase V. When a dog graduates from training, it is given
	 * the status of “in-service” and is considered a Rescue Animal. If a dog does not successfully make
	 * it through training, it is given the status of “farm,” indicating that it will live a life of leisure on a
	 * Grazioso Salvare farm.
	 *
	 * <p><ul>
	 *      <li>Acceptable reserve status:</li>
	 *      <ul>
	 *         <li>intake</li>
	 *          <li>Phase I,</li>
	 *          <li>Phase II</li>
	 *          <li>Phase III,</li>
	 *          <li>Phase IV</li>
	 *          <li>Phase V</li> farm
	 *          <li>in-service</li>
	 *          <li>farm</li>
	 *
	 * @param trainingStatus see above Acceptable reserve status:
	 */
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
}
