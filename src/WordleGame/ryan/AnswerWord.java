package WordleGame.ryan;

// import relevant packages
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class AnswerWord {

    // setting up instance variable
    public String answer;

    /**
     * Constructor
     * Calls the getRandomWord() method to assign the variable "answer" a five letter word
     */
    public AnswerWord() throws FileNotFoundException {
        this.getRandomWord();
    }

    /**
     * Private method: getRandomWord()
     * This method picks a word from a txt file of common used words. This method will be
     * called in the constructor when a new instance is created. It assigns a 5 lettered word
     * to the variable "word".
     * @param: None. This method does not accept any data.
     * @Return: a
     */
    private void getRandomWord() throws FileNotFoundException {
        int randomIndex = (int) ((Math.random() * ((getValidWordsArray().length - 1) - 0)) + 0);
        answer = getValidWordsArray()[randomIndex];
    }

    /**
     * Private method: getValidWordsArray()
     * This method will be used in getRandomWord() method
     * @param: None
     * @return a String Array of 5 lettered words
     */
    private String[] getValidWordsArray () throws FileNotFoundException {

        // obtain the fulltext as a string
        String fullText = "";
        try {
            // obtain the data of the file CommonWords
            Scanner fileScanner = new Scanner(new File("/Users/jiruihan/Desktop/NYU/2023 Spring/CSCI-UA 101/Personal/WordleGamePractice/CommonWords.txt"));
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
     * method: getAnswerWordArray()
     * @param: None
     * @return: a length 5 character Array split by letters from the word
     */
    public char[] getAnswerWordArray() {

        // create an empty length 5 chracter Array
        char[] answerWordArray = new char[5];

        // use a for loop to arrange letters into an Array
        for (int letterIndex = 0; letterIndex < 5; letterIndex++) {
            answerWordArray[letterIndex] = answer.charAt(letterIndex);
        }

        // return the Array
        return answerWordArray;
    }
}
