package WordleGame.ryan;

// import relevant packages
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerWord {

    // set up variables
    public String userInput;

    /**
     * constructor: PlayerWord
     * Asks the player for a five lettered word, validates it, and assign it to the String userInput.
     */
    public PlayerWord() {

        // prompt the user for a word
        Scanner scanner = new Scanner(System.in);
        boolean validity = false;
        while (!validity) {
            System.out.print("  Your guess: ");
            String userGuess = scanner.nextLine();
            if (isValidGuess(userGuess)) {  // checks validity
                userInput = userGuess;  // assigns the value to the variable
                validity = true;
            }
        }
        System.out.print("(ACCEPTED)");

    }

    /**
     * method getAllWordsArray()
     * Takes no arguments
     * @return a String Array of all permitted words
     */
    private String[] getAllWordsArray() {
        // obtain the fulltext as a string
        String fullText = "";
        try {
            // obtain the data of the file CommonWords
            Scanner fileScanner = new Scanner(new File("/Users/jiruihan/Desktop/NYU/2023 Spring/CSCI-UA 101/Personal/WordleGamePractice/AllWords.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                fullText += line.toUpperCase() + ",";
            }
            fileScanner.close();  // close the scanner
        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        // split the string into an Array
        String[] words = fullText.split(",");

        int validArrayLength = 0; // setting up a counter
        String[] fiveLetteredWords = {}; // setting up an empty Array

        // using a for each loop to iterate through all the words
        for (String word : words) {
            if (word.length() == 5) {  // if the word length is 5
                validArrayLength ++;  // add one to the counter
                fiveLetteredWords = Arrays.copyOf(fiveLetteredWords, validArrayLength);  // make copy of the Array and lengthen by one
                fiveLetteredWords[validArrayLength - 1] = word;  // assign the word into the Array
            }
        }
        return fiveLetteredWords;  // return the Array
    }


    /**
     * method: isValidGuess()
     * checks if an input is 5 in length, all alphabetic, and is a valid word in the AllWords array.
     * @param userInput The string of the user's attempt
     * @return a boolean Whether is guess is valid or not
     */
    private boolean isValidGuess (String userInput) {
        if (userInput.length() != 5) {
            System.out.print(" (INVALID)                                        ");
            return false;
        } else {
            for (int i = 0; i < 5; i ++) {
                if (!Character.isAlphabetic(userInput.charAt(i))) {
                    System.out.print(" (INVALID)                                        ");
                    return false;
                }
            }
            if (BinarySearch.binarySearch(getAllWordsArray(), userInput.toUpperCase())) {
                return true;
            } else {
                System.out.print(" (INVALID)                                        ");
                return false;
            }
        }
    }


    /**
     * method getUserInputArray()
     * @param: None.
     * @return a length 5 character Array split by letters from the user input
     */
    public char[] getUserInputArray() {
        // create an empty length 5 chracter Array
        char[] userInputArray = new char[5];
        // use a for loop to arrange letters into an Array
        for (int letterIndex = 0; letterIndex < 5; letterIndex++) {
            userInputArray[letterIndex] = userInput.toUpperCase().charAt(letterIndex);
        }
        // return the Array
        return userInputArray;
    }

}

