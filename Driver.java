import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)

    public enum AcceptedAnimal{
        DOG,
        MONKEY
    }





    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean quitApp = true;
        initializeDogList();
        initializeMonkeyList();

        // Main loop
        while (quitApp != false) {
            char userChoice;
            displayMenu();
            userChoice = scanner.next().charAt(0);

            switch (userChoice) {
                case 'q':
                    System.out.println("You entered q ");

                    quitApp = false;
                    break;

                case '1':
                    System.out.println("You entered an 1");
                    intakeNewDog(scanner);
                    break;

                case '2':
                    System.out.println("You entered an  2");
                    break;

                case '3':
                    System.out.println("You entered an 3");
                    break;

                case '4':
                    System.out.println("You entered an 4");
                    break;

                case '5':
                    System.out.println("You entered an 5");
                    break;

                case '6':
                    System.out.println("You entered an 6");
                    break;

                default:
                    System.out.println("You entered an incorrect value please try again");
                    break;
            }


        }

        /*
         Add a loop that displays the menu, accepts the users input
         and takes the appropriate action.
         For the project submission you must also include input validation
         and appropriate feedback to the user.
         Hint: create a Scanner and pass it to the necessary
         methods
         Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        */

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


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        System.out.println("The method initializeMonkeyList needs to be implemented");
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you

    public static String getInput(Scanner scanner, String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        System.out.println("/n");
        return input;
    };


    //TODO Finish fleshing out
    public static RescueAnimal intakeNewAnimal(Scanner scanner, AcceptedAnimal acceptedAnimal){
        //shorthand if else statement with ENUM checking if
        String animalType = (acceptedAnimal == AcceptedAnimal.DOG) ? "dog" : "monkey";

        String name = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        String gender = Driver.getInput(scanner, "What is your " + animalType + "'s gender\n" +
                "");
        String age = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        String weight = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        String acquisitionDate = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        String acquisitionCountry = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        String trainingStatus = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        //TODO add get bool
//        String acquisitionDate = Driver.getInput(scanner, "What is your " + animalType + "'s name");
        String inServiceCountry = Driver.getInput(scanner, "What is your " + animalType + "'s name");

        //dog
        if (acceptedAnimal == AcceptedAnimal.DOG){
            String breed= Driver.getInput(scanner, "What is your " + animalType + "'s breed");

            Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, false, inServiceCountry);
            return dog;


        }
        // monkey
        else if ((acceptedAnimal == AcceptedAnimal.MONKEY)){

        }



        /*
        private boolean reserved;
        private String inServiceCountry;*/

        //return a rescue animal

        System.out.println("What is the " + animalType +  "'s breed ?");
        String breed = scanner.nextLine();
        System.out.println("/n");

        return ;


    }

    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine(); // clearing the scanner input
        name = scanner.nextLine();

        // check if dog is in list
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            } else {
                // TODO logic for making new dog

                /*
                Generic methods
                What is the same for dog class and monkey
                Add class overflow
                Intake class... vs method

                 */
                AcceptedAnimal acceptedAnimal = AcceptedAnimal.DOG;
                intakeNewAnimal( scanner,acceptedAnimal);


                System.out.println("What is the dog's name?");
                String breed = scanner.nextLine();
                System.out.println("/n");



                // Dog dog = new Dog(name, breed, gender, age, "25.6", "05-12-2019", "United States", "intake", false, "United States");
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("The method intakeNewMonkey needs to be implemented");
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
    public static void printAnimals() {
        System.out.println("The method printAnimals needs to be implemented");

    }
}

