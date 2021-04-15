import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

/**
 * Grazioso Salvare program is an application that manages administration of
 * search and rescue animals
 *
 * @author Grazioso Salvare
 * @version 0.1.0
 * @since 2021-04-11
 */
public class Driver {
    private static final ArrayList<Dog> dogList = new ArrayList<>();
    private static final ArrayList<Monkey> monkeyList = new ArrayList<>();


    //list storing all countries
    //private static final Locale list[] = DateFormat.getAvailableLocales();


    /**
     * main method: used as the main operating loop of the program
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quitApp = false;


        // for testing only
        initializeDogList();
        //initializeMonkeyList();

        // Main loop
        while (!quitApp) {
            char userChoice;
            displayMenu();
            userChoice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline left-over Do not remove

            switch (userChoice) {
                //quit
                case 'q':
                    System.out.println("\nExiting the program\n");
                    quitApp = true;
                    break;

                // intake new dog
                case '1':
                    intakeNewDog(scanner);
                    break;

                //intake new monkey
                case '2':
                    intakeNewMonkey(scanner);
                    break;

                //Reserve an animal
                case '3':
                    reserveAnimal(scanner);
                    break;

                //print a list of all dogs
                case '4':
                    printAnimals(AcceptedAnimal.DOG);
                    break;

                //print a list of all monkeys
                case '5':
                    printAnimals(AcceptedAnimal.MONKEY);
                    break;

                // Print list of all non- reserved animals
                case '6':
                    printAnimals(AcceptedAnimal.AVAILABLE);
                    break;

                default:
                    System.out.println("You entered an incorrect value please try again");
                    break;
            }
        }
    }

    /**
     * Displays the main menu to the console
     */
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    /**
     * Adds dogs to a list for testing Optional
     */
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    /**
     * getInput method gets user input based on a question. This  method to for printing to keep DRY
     *
     * @param scanner  Scanner object passed to method
     * @param question String passed as an argument displayed to the user
     * @return string input
     */
    public static String getInput(Scanner scanner, String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        System.out.print("\n");
        return input;
    }

    /**
     * This method prints animal type and name added successfully
     *
     * @param name       Name of animal
     * @param animalType type of rescue animal dog or monkey
     */
    public static void animalAdded(String name, String animalType) {
        System.out.println("\nNew " + animalType + " named " + name + " added successfully\n");
    }


    /**
     * This method takes creates a initialises a rescue animal object based on type and passes the return Animal object
     * to intakeNewDog or  or intakeNewMonkey
     *
     * @param scanner        Scanner object passed as scanner
     * @param acceptedAnimal accepted values ENUM: DOG, MONKEY
     * @param name           Name of animal object
     * @return monkey or dog class to the method intakeNewDog or intakeNewMonkey based on acceptedAnimal peram
     */
    public static RescueAnimal intakeNewAnimal(Scanner scanner, AcceptedAnimal acceptedAnimal, String name) {
        //shorthand if else statement with ENUM.
        String animalType = (acceptedAnimal == AcceptedAnimal.DOG) ? "dog" : "monkey";
        String gender = Driver.getInput(scanner, "What is your " + animalType + "'s gender");
        String age = Driver.getInput(scanner, "What is your " + animalType + "'s age");
        String weight = Driver.getInput(scanner, "What is your " + animalType + "'s weight in lbs ");
        String acquisitionDate = validatesDate(scanner, animalType);
        String acquisitionCountry = validateCountry(scanner, animalType);
        // all new new animals start as intake and in the united states and are not reserved
        String trainingStatus = "Intake";
        String inServiceCountry = "United States";
        boolean reserved = false;

        //add dog to dog list + par
        if (acceptedAnimal == AcceptedAnimal.DOG) {
            String breed = null;
            try {
                breed = validateDogBreed(scanner, animalType);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Dog dog = new Dog(name, breed, gender, age,
                    weight, acquisitionDate, acquisitionCountry,
                    trainingStatus, reserved, inServiceCountry);
            animalAdded(name, animalType);
            return dog;
        }

        // monkey
        else if (acceptedAnimal == AcceptedAnimal.MONKEY) {
            String species = validateMonkeyBreed(scanner,animalType);
            String bodyLength = Driver.getInput(scanner, "Enter  " + animalType + " body length in inches");
            String tailLength = Driver.getInput(scanner, "Enter  " + animalType + " tail length in inches");
            String height = Driver.getInput(scanner, "Enter  " + animalType + " height in inches");

            //initialise new monkey
            Monkey monkey = new Monkey(name, species, gender, age,
                    weight, acquisitionDate, acquisitionCountry,
                    trainingStatus, reserved, inServiceCountry,
                    bodyLength, tailLength, height);
            animalAdded(name, animalType);
            return monkey;
        }

        System.out.println("Error in method intakeNewAnimal returned null contact vendor with this error message ");
        return null;
    }

    /**
     * This method is used in the main loop of the program as an option to add a new dog.Gets the the dogs name from the user
     * and checks if dogs name exists in the dogList. If it does not exist this method sets accepted animal to DOG and passes
     * the scanner, AcceptedAnimal.DOG and name to intakeNewAnimal method. it takes the return object of Rescue Animal
     * and casts to to a dog object and adds it to dogList
     *
     * @param scanner Scanner object
     */
    public static void intakeNewDog(Scanner scanner) {
        String name = Driver.getInput(scanner, "\nWhat is your dogs name");

        // check if dog is in list
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        //logic for creating a new dog object
        AcceptedAnimal acceptedAnimal = AcceptedAnimal.DOG;
        RescueAnimal newDog;
        newDog = intakeNewAnimal(scanner, acceptedAnimal, name);
        // intakeNewAnimal returns a RescueAnimal object, cast to a Dog object
        dogList.add((Dog) newDog);
    }

    /**
     * This method is used in the main loop of the program as an option to add a new Monkey.Gets the the monkey name from the user
     * and checks if Monkey name exists in the monkeyList. If it does not exist this method sets accepted animal to MONKEY and passes
     * the scanner, AcceptedAnimal.MONKEY and name to intakeNewAnimal method. it takes the return object of Rescue Animal
     * and casts to to a monkey object and adds it to monkeyList.
     *
     * @param scanner Scanner object
     */
    public static void intakeNewMonkey(Scanner scanner) {
        String name = Driver.getInput(scanner, "\nWhat is the monkeys name");
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkeys is already in our system\n\n");
                return; //returns to menu
            }
        }
        //logic for creating a new dog object
        AcceptedAnimal acceptedAnimal = AcceptedAnimal.MONKEY;
        RescueAnimal newMonkey;
        newMonkey = intakeNewAnimal(scanner, acceptedAnimal, name);
        // intakeNewAnimal returns a RescueAnimal object, cast to a monkey object
        monkeyList.add((Monkey) newMonkey);
    }

    /**
     * This method prints to the console and error message for reserving an rescue animal
     */
    public static void printReserveError() {
        System.out.println("There was an error in the selection.\n" +
                "possible reason:\n" +
                "Animal name spelled incorrectly.\n" +
                "No animal's available to check out.\n" +
                "Please try again.");
    }

    /**
     * this method prints out all animal's not in a reserve status
     * Changes animal reserve type reserved based on animal name uses printDog or printMonkey methods.
     *
     * @param scanner Driver scanner object Animal name
     */
    public static void reserveAnimal(Scanner scanner) {
        String name;
        int animalsToCheckout = -1;
        printAnimals(AcceptedAnimal.AVAILABLE);

        System.out.println();// add a space before question
        name = getInput(scanner, "Enter an animal name that you would like to reserve or type quit to cancel");

        if (name.equalsIgnoreCase("quit")) {
            System.out.println("You entered quit returning to main menu");
            return;
        }

        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                dog.setReserved(true);
                printDog(dog);
                animalsToCheckout = 1;
                break;
            }
        }

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                monkey.setReserved(true);
                printMonkey(monkey);
                animalsToCheckout = 1;
                break;
            }
        }

        // reserve error
        if (animalsToCheckout != 1) {
            printReserveError();
        }
    }

    /**
     * This method prints out dogs name, status, acquisition country and its reserve status and counts and displays
     * number of dogs in the list. This method used for multiple dog objects
     *
     * @param i   iterator for numbers of dogs in a list
     * @param dog DOG current dog object
     */
    public static void printDog(int i, Dog dog) {
        System.out.println("\nDog number " + i + ":");
        System.out.print("Name: " + dog.getName() + "\n" +
                "Status: " + dog.getTrainingStatus() + "\n" +
                "Acquisition country: " + dog.getAcquisitionLocation() + "\n" +
                "Reserved: " + dog.getReserved() + "\n");
    }

    /**
     * This method prints out dog name, status, acquisition country and its reserve status.
     * This method used for singular dog objects
     *
     * @param dog DOG single dog object
     */
    public static void printDog(Dog dog) {
        System.out.print("Name: " + dog.getName() + "\n" +
                "Status: " + dog.getTrainingStatus() + "\n" +
                "Acquisition country: " + dog.getAcquisitionLocation() + "\n" +
                "Reserved: " + dog.getReserved() + "\n");
    }

    /**
     * This method prints out monkey name, status, acquisition country and its reserve status and counts and displays
     * number of monkeys in the list. This method used for multiple monkey objects
     *
     * @param i      iterator for numbers of monkeys in a list
     * @param monkey DOG current dog object
     */
    public static void printMonkey(int i, Monkey monkey) {
        System.out.println("\nMonkey number " + i + ":");
        System.out.print("Name: " + monkey.getName() + "\n" +
                "Status: " + monkey.getTrainingStatus() + "\n" +
                "Acquisition country: " + monkey.getAcquisitionLocation() + "\n" +
                "Reserved: " + monkey.getReserved() + "\n");
    }

    /**
     * This method prints out monkey name, status, acquisition country and its reserve status.
     * This method used for singular monkey objects
     *
     * @param monkey single monkey object
     */
    public static void printMonkey(Monkey monkey) {
        System.out.print("Name: " + monkey.getName() + "\n" +
                "Status: " + monkey.getTrainingStatus() + "\n" +
                "Acquisition country: " + monkey.getAcquisitionLocation() + "\n" +
                "Reserved: " + monkey.getReserved() + "\n");
    }

    /**
     * The method has three different outputs based on the ENUM AcceptedAnimal listType parameter
     *
     * @param listType DOG - prints the list of dogs,
     *                 MONKEY - prints the list of monkeys AVAILABLE -
     *                 prints a combined list of all animals that are fully trained ("in service") but not reserved
     */
    public static void printAnimals(AcceptedAnimal listType) {
        int i = 0;

        switch (listType) {
            case DOG:
                for (Dog dog : dogList) {
                    i++;
                    printDog(i, dog);
                }
                break;

            case MONKEY:
                for (Monkey monkey : monkeyList) {
                    i++;
                    printMonkey(i, monkey);
                }
                break;

            case AVAILABLE:
                // Prints out dog's
                System.out.println("\nDog's not reserved:");
                for (Dog dog : dogList) {
                    //print out dog that is not reserved
                    if (!dog.getReserved()) {
                        i++;
                        printDog(i, dog);

                    }
                }
                System.out.println("\nThere are " + i + " dogs available to reserve");

                //loop through monkey array list and numbers them
                i = 0;
                System.out.println("\nMonkeys not reserved:");
                for (Monkey monkey : monkeyList) {
                    //print out monkey that is not reserved
                    if (!monkey.getReserved()) {
                        i++;
                        printMonkey(i, monkey);
                    }
                }
                System.out.println("\nThere are " + i + " monkeys available to reserve");
                break;

            default:
                System.out.println("Error in method printAnimals, contact vendor with this error message");
                break;
        }
    }

    /**
     * This method takes creates an ArrayList of all countries
     * <p>
     * It use the list named Local <code>DateFormat.getAvailableLocales()</code> of all available countries codes.
     * It converts the country codes to country names using <code>.getDisplayCountry()</code> method.
     * The Locale list is looped through and white space is ignored. The aLocale is added to an arraylist named
     * countryList. countryList is sorted alphabetically.
     * <p>
     *
     * @return A sorted ArrayList of all countries
     * @see DateFormat#getAvailableLocales()
     * @see Locale#getDisplayCountry()
     */
    public static ArrayList<String> createCountryList() {
        ArrayList<String> countryList = new ArrayList<>(); //create country list
        Locale[] list = DateFormat.getAvailableLocales(); // create locale list
        for (Locale aLocale : list) {
            if (aLocale.getDisplayCountry().equals("") || countryList.contains(aLocale.getDisplayCountry())) {
                continue;// remove whitespace from list
            }
            countryList.add(aLocale.getDisplayCountry());//add country name to array list without
        }
        Collections.sort(countryList); // sort Alphabetical
        return countryList;
    }

    /**
     * The user is asked to input the country name, it is checked against known countries.
     *
     * @param scanner    Driver scanner object
     * @param animalType type dog or cat
     * @return country string
     */
    public static String validateCountry(Scanner scanner, String animalType) {
        ArrayList<String> countryList = createCountryList();
        String country;
        boolean countryValidated;

        country = "-1";
        countryValidated = false;

        //validate country
        while (!countryValidated) {
            country = Driver.getInput(scanner, "What country did you get the " + animalType);
            for (String enteredCountry : countryList) {
                if (country.equalsIgnoreCase(enteredCountry)) {
                    countryValidated = true;
                    break;
                }
            }
            if (!countryValidated) {
                for (String counter : countryList) {
                    System.out.println(counter);
                }
                System.out.print("\nCountry is not found, printing known countries please check spelling\n" +
                        "in above list or use copy and paste\n\n");
            }
        }
        return country;
    }

    /**
     * This method gets user input for date
     *
     * @param scanner    Scanner object
     * @param animalType Dog or Monkey
     * @return validated string date in format  mm-dd-yyyy
     */
    public static String validatesDate(Scanner scanner, String animalType) {
        String date = "-1";
        String dateRegex = "^(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02/(0[1-9]|[1-2][0-9]))|" +
                "((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))-[0-9]{4}$";

        while (!date.matches(dateRegex)) { // the break removes the need for date
            date = Driver.getInput(scanner, "What date did you acquire the " + animalType +
                    " : enter mm-dd-yyyy\n" +
                    "eg 05-12-2019");
            if (!date.matches(dateRegex)) {
                System.out.println("Inputted Date format is incorrect try again\n");
            }
        }
        return date;
    }

    /**
     * This method creates an a list of dog breeds based on a file from wiki.
     *
     * @return Arraylist dogBreeds
     * @throws FileNotFoundException if file not found
     */
    public static ArrayList<String> createDogBreedList() throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("dogList.txt"));
        ArrayList<String> dogBreeds = new ArrayList<>(); //create country list

        // read until end of file (EOF)
        while (fileReader.hasNextLine()) {
            dogBreeds.add(fileReader.nextLine());
        }
        fileReader.close();
        return dogBreeds;
    }

    /**
     * This function validates the breed of dog.
     *
     * @param scanner    scanner object
     * @param animalType dog or monkey
     * @return validated sting breed
     * @throws FileNotFoundException if dogList.txt is not found
     */
    public static String validateDogBreed(Scanner scanner, String animalType) throws FileNotFoundException {
        ArrayList<String> dogBreed = createDogBreedList();
        String breed= "-1";
        boolean breedValidated = false;

        //breed
        while (!breedValidated) {
            breed = Driver.getInput(scanner, "What type of breed is the " + animalType);
            for (String enteredBreed : dogBreed) {
                if (breed.equalsIgnoreCase(enteredBreed)) {
                    breedValidated = true;
                    break;
                }
            }
            if (!breedValidated) {
                for (String dog : dogBreed) {
                    System.out.println(dog);
                }
                System.out.print("\nDog breed is not found, printing breeds of dogs please check spelling\n" +
                        "in above list or use copy and paste\n\n");
            }
        }
        return breed;
    }

    public static String validateMonkeyBreed(Scanner scanner, String animalType){
       String[] monkeyArr ={"Capuchin","Guenon","Macaque","Marmoset","Tamarin"};
        boolean breedValidated = false;
        String monkeyBreed= null;

       while(!breedValidated){
            monkeyBreed = Driver.getInput(scanner, "Acceptable species of " + animalType + " for training are:\n" +
                   "Capuchin\n" +
                   "Guenon\n" +
                   "Macaque\n" +
                   "Marmoset\n" +
                   "Squirrel monkey\n" +
                   "Tamarin\n\n" +
                   "Please enter an acceptable species of " + animalType);

           for (String monkey:monkeyArr){
               if(monkeyBreed.equalsIgnoreCase(monkey)){
                   breedValidated = true;
                   break;
               }
           }

           if(!breedValidated){
               System.out.println("Incorrect species of " + animalType + " Please try again. \n");
           }
       }
        return monkeyBreed;
    }

    /**
     * Enum for type of animal and if its available DOG, MONKEY and AVAILABLE
     */
    public enum AcceptedAnimal {
        DOG,
        MONKEY,
        AVAILABLE
    }
}


