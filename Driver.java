import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static final ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static final ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quitApp = true;

        // for testing only
        initializeDogList();
        initializeMonkeyList();

        // Main loop
        while (quitApp != false) {
            char userChoice;
            displayMenu();
            userChoice = scanner.next().charAt(0);
            String clearScanner = scanner.nextLine(); // clearing the scanner input

            switch (userChoice) {
                //quit
                case 'q':
                    System.out.println("You entered q ");
                    quitApp = false;
                    break;

                // intake new dog
                case '1':
                    System.out.println("\nYou entered an 1\n");
                    intakeNewDog(scanner);
                    break;

                //intake new monkey
                case '2':
                    System.out.println("You entered an  2");
                    break;

                //Reserve an animal
                case '3':
                    System.out.println("You entered an 3");
                    reserveAnimal(scanner);
                    break;

                //print a list of all dogs
                case '4':
                    System.out.println("You entered an 4");
                    printDogList();
                    break;

                //print a list of all monkeys
                case '5':
                    System.out.println("You entered an 5");
                    printMonkeyList();
                    break;

                //Print a list of all animals that are not reserved
                case '6':
                    System.out.println("You entered an 6");
                    printAnimals();
                    break;

                default:
                    System.out.println("You entered an incorrect value please try again");
                    break;
            }
        }
    }

    // This method prints the menu options
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

    // Adds dogs to a list for testing Optional
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing Optional
    public static void initializeMonkeyList() {
        System.out.println("The method initializeMonkeyList needs to be implemented");
    }

    // method to for printing to keep the code DRY
    public static String getInput(Scanner scanner, String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        System.out.print("\n");
        return input;
    }

    public static void animalAdded(String name, String animalType) {
        System.out.println("\nNew " + animalType + " named " + name + " added successfully\n");
    }

    //TODO Finish fleshing out if a dog or monkey
    public static RescueAnimal intakeNewAnimal(Scanner scanner, AcceptedAnimal acceptedAnimal, String name) {
        //shorthand if else statement with ENUM.
        //TODO input validation for each input after finishing the rest of the program
        String animalType = (acceptedAnimal == AcceptedAnimal.DOG) ? "dog" : "monkey";
        String gender = Driver.getInput(scanner, "What is your " + animalType + "'s gender");
        String age = Driver.getInput(scanner, "What is your " + animalType + "'s age");
        String weight = Driver.getInput(scanner, "What is your " + animalType + "'s weight in lbs ");
        String acquisitionDate = Driver.getInput(scanner, "What date did you acquire the " + animalType + " : enter mm-dd-yyyy\n" +
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
        // prints out dog object memory location.
        System.out.println(dogList.toString());
    }

    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
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

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("The method reserveAnimal needs to be implemented");

    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is reserved.
    // Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
    // Remember that you only have to fully implement ONE of these lists.
    // The other lists can have a print statement saying "This option needs to be implemented".
    // To score "exemplary" you must correctly implement the "available" list.

    public static void printDogList() {
        System.out.println("[4] Print a list of all dogs");

    }

    public static void printMonkeyList() {
        System.out.println("[5] Print a list of all monkeys");

    }


    public static void getNotReserved() {

    }

    public static void printAnimals() {

        //loop through dog array list
        for (Dog dog : dogList) {
            //print out dog that is not reserved
            if (dog.getReserved() == false) {
                System.out.print("Dog named " + dog.getName() + " is not reserved");
            }
        }

        //loop through monkey array list
        for (Monkey monkey : monkeyList) {
            //print out monkey that is not reserved
            if (monkey.getReserved() == false) {
                System.out.print("Monkey named " + monkey.getName() + " is not reserved");
            }
        }
    }

    public enum AcceptedAnimal {
        DOG,
        MONKEY
    }


}

