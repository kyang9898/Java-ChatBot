import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(String[] args) {
        greetUser();
        var repeatName = repeatName();
        var guessAge = guessAge();
        var countNumber = countNumber();
        var programKnowledge = programmingKnowledge();
        
        var storyLines = new String[] { repeatName, guessAge, countNumber, programKnowledge};
        tellStory(storyLines);
    }

    public static void tellStory(String[] storyLines)
    {
        System.out.println("-------------------------------------");
        System.out.println("Story time.");
        for(int i = 0; i < storyLines.length; i++){
            System.out.println(storyLines[i]);
        }
    }
    public static void greetUser() {
        System.out.println("Hello, I am Chat Bot.");
    }

    public static String repeatName() {
        System.out.println("-------------------------------------");
        String result = "";

        Scanner keyboard = new Scanner(System.in);

        var nameMatch = false;

        while (!nameMatch) {
            System.out.println("What is your name?");
            String firstInputName = keyboard.nextLine();
            // System.out.println(firstInputName);

            System.out.println("Can you repeat your name?");
            String secondInputName = keyboard.nextLine();
            // System.out.println(secondInputName);

            if (!firstInputName.equals(secondInputName)) {
                System.out.println("Sorry, names do not match. Try again.");
            } else {
                result = "Your name is " + firstInputName;
                nameMatch = true;
            }
        }

        // System.out.println(result);

        return result;
    }

    public static String guessAge() {
        System.out.println("-------------------------------------");
        String result = "";

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Lets guess your age.");
        System.out.println("What year were you born. (ex. 2001)");
        int birthYear = keyboard.nextInt();

        System.out.println("What month were you born. (ex. 12)");
        int birthMonth = keyboard.nextInt();

        System.out.println("What day were you born. (ex. 10)");
        int birthDay = keyboard.nextInt();

        LocalDate dateOfBirth = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate today = LocalDate.now();

        var age = (int) ChronoUnit.YEARS.between(dateOfBirth, today);

        result = "You are " + age + " years old";
        System.out.println(result);

        return result;
    }

    public static String countNumber() {
        System.out.println("-------------------------------------");
        var result = "";

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Give me a number to count to.");
        System.out.println("Start number.");
        int startCount = keyboard.nextInt();
        System.out.println("End number.");
        int endCount = keyboard.nextInt();

        result = "You wanted to count from " + startCount + " to " + endCount;
        // System.out.println(result);

        System.out.println("Counting numbers...");

        if(startCount == endCount){
            System.out.println(startCount);
        }
        else if (startCount < endCount) {
            for (int i = startCount; i <= endCount; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = endCount; i <= startCount; i++) {
                System.out.println(i);
            }
        }

        return result;
    }

    public static String programmingKnowledge() {
        System.out.println("-------------------------------------");
        // var intArray = new int[] { 99, -5, 2, 6, 11, 0 };
        // var max = intArray[0];

        var result = "";

        Scanner keyboard = new Scanner(System.in);
        var isCorrect = false;

        while (!isCorrect) {
            System.out.println("Which of the following choices will get you the max integer of the array below?");
            System.out.println("var intArray = new int[] { 99, -5, 2, 6, 11, 0 };");
            System.out.println("a. intArray.getMax();");
            System.out.println("b. 99");
            System.out.println("c. intArray[0];");
            System.out.println("d. intArray[1]");
            System.out.println("e. intArray[99]");
            System.out.println("f. none of the above");

            var answer = keyboard.nextLine();
            if (answer.toLowerCase().equals("c")) {
                result = "You know that \"c. intArray[0]\" will get you the max integer of \"var intArray = new int[] { 99, -5, 2, 6, 11, 0 };\"";
                System.out.println("Correct!");
                // System.out.println(result);
                isCorrect = true;
            } else {
                System.out.println("Incorrect! Try again.");
            }
        }

        return result;
    }
}