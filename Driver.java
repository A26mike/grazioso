import java.util.ArrayList;
import java.util.Scanner;

/**
 * Grazioso Salvare program is an application that manages administration of
 * search and rescue animals
 *
 * @since 2021-04-11
 * @version 0.1.0
 * @author Grazioso Salvare
 */
public class Driver {
    private static final ArrayList<Dog> dogList = new ArrayList<>();
    private static final ArrayList<Monkey> monkeyList = new ArrayList<>();


    /**
     * main method: used as the main operating loop of the program
     * @param args Unused
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quitApp = false;

        // for testing only
        initializeDogList();
        initializeMonkeyList();

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
     *Displays the main menu to the console
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
     * Adds monkeys to a list for testing Optional
     */
    public static void initializeMonkeyList() {
        System.out.println("The method initializeMonkeyList needs to be implemented");
    }

    // method to for printing to keep the code DRY
    //TODO refactor for <t> generic type method.
    /**
     *getInput method gets user input based on a question. This  method to for printing to keep the code DRY.
     * @param scanner Scanner object passed to method
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
     * @param name Name of animal
     * @param animalType type of rescue animal dog or monkey
     */
    public static void animalAdded(String name, String animalType) {
        System.out.println("\nNew " + animalType + " named " + name + " added successfully\n");
    }

    //

    /**
     *This method takes creates a initialises a rescue animal object based on type and passes the return Animal object
     * to intakeNewDog or  or intakeNewMonkey
     * @param scanner Scanner object passed as scanner
     * @param acceptedAnimal accepted values ENUM: DOG, MONKEY
     * @param name Name of animal object
     * @return monkey or dog class to the method intakeNewDog or intakeNewMonkey based on acceptedAnimal peram
     */
    public static RescueAnimal intakeNewAnimal(Scanner scanner, AcceptedAnimal acceptedAnimal, String name) {
        //shorthand if else statement with ENUM.
        //TODO input validation for each input after finishing the rest of the program
        String animalType = (acceptedAnimal == AcceptedAnimal.DOG) ? "dog" : "monkey";
        String gender = Driver.getInput(scanner, "What is your " + animalType + "'s gender");
        String age = Driver.getInput(scanner, "What is your " + animalType + "'s age");
        String weight = Driver.getInput(scanner, "What is your " + animalType + "'s weight in lbs ");
        String acquisitionDate = Driver.getInput(scanner, "What date did you acquire the " + animalType +
                " : enter mm-dd-yyyy\n" +
                "eg 05-12-2019");
        String acquisitionCountry = Driver.getInput(scanner, "What country did you get the " + animalType);
        // all new new animals start as intake and in the united states and are not reserved
        String trainingStatus = "intake";
        String inServiceCountry = "United States";
        boolean reserved = false;

        //add dog to dog list + par
        if (acceptedAnimal == AcceptedAnimal.DOG) {
            String breed = Driver.getInput(scanner, "What is your " + animalType + "'s breed");
            Dog dog = new Dog(name, breed, gender, age,
                    weight, acquisitionDate, acquisitionCountry,
                    trainingStatus, reserved, inServiceCountry);
            animalAdded(name, animalType);
            return dog;
        }

        // monkey
        else if (acceptedAnimal == AcceptedAnimal.MONKEY) {
            //parameters unique to monkey
            String species = Driver.getInput(scanner, "Acceptable species of " + animalType + " for training are:\n" +
                    "Capuchin\n" +
                    "Guenon\n" +
                    "Macaque\n" +
                    "Marmoset\n" +
                    "Squirrel monkey\n" +
                    "Tamarin\n\n" +
                    "Please enter an acceptable species of " + animalType);

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
     *This method is used in the main loop of the program as an option to add a new dog.Gets the the dogs name from the user
     * and checks if dogs name exists in the dogList. If it does not exist this method sets accepted animal to DOG and passes
     * the scanner, AcceptedAnimal.DOG and name to intakeNewAnimal method. it takes the return object of Rescue Animal
     * and casts to to a dog object and adds it to dogList
     * @param scanner Scanner object
     */
    public static void intakeNewDog(Scanner scanner) {
        String name = Driver.getInput(scanner, "What is your dogs name");

        // check if dog is in list
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        //logic for creating a new dog object
        AcceptedAnimal acceptedAnimal = AcceptedAnimal.DOG;
        RescueAnimal newDog = intakeNewAnimal(scanner, acceptedAnimal, name);
        // intakeNewAnimal returns a RescueAnimal object, cast to a Dog object
        dogList.add((Dog) newDog);
    }


    //TODO Prompts the user for input and validates based on monkey name and
    //  species type project submission you must also  validate the input

    /**
     *This method is used in the main loop of the program as an option to add a new Monkey.Gets the the monkey name from the user
     * and checks if Monkey name exists in the monkeyList. If it does not exist this method sets accepted animal to MONKEY and passes
     * the scanner, AcceptedAnimal.MONKEY and name to intakeNewAnimal method. it takes the return object of Rescue Animal
     * and casts to to a monkey object and adds it to monkeyList.
     * @param scanner Scanner object
     */
    public static void intakeNewMonkey(Scanner scanner) {
        String name = Driver.getInput(scanner, "What is the monkeys name");
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkeys is already in our system\n\n");
                return; //returns to menu
            }
        }
        //logic for creating a new dog object
        AcceptedAnimal acceptedAnimal = AcceptedAnimal.MONKEY;
        RescueAnimal newMonkey = intakeNewAnimal(scanner, acceptedAnimal, name);
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

    //TODO check if there are no animals to reserve
    /**
     * this method prints out all animal's not in a reserve status
     * Changes animal reserve type reserved based on animal name uses printDog or printMonkey methods.
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
     * @param i iterator for numbers of dogs in a list
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
     *  This method used for singular dog objects
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
     * @param i iterator for numbers of monkeys in a list
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
     *  This method used for singular monkey objects
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
     * @param listType DOG - prints the list of dogs, MONKEY - prints the list of monkeys AVAILABLE - prints a combined list of all animals that are fully trained ("in service") but not reserved
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
     * Enum for type of animal and if its available DOG, MONKEY and AVAILABLE
     */
    public enum AcceptedAnimal {
        DOG,
        MONKEY,
        AVAILABLE
    }

}

