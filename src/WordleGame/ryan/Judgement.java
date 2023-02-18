package WordleGame.ryan;

import java.util.Arrays;

public class Judgement {

    /**
     * method presenceChar()
     * @param answerLetter a char array from the answer word string
     * @param guessLetter a char from the guess word string
     * @return a boolean, whether the char presents but not necessarily at the right position ,
     */
    private static boolean presenceChar (char[] answerLetter, char guessLetter) {
        // set up a boolean variable
        boolean presence = false;
        // make a copy of the array, in order to modify it.
        // for each loop to iterate through the Array
        for (int i = 0; i < 5; i++) {
            if (guessLetter == answerLetter[i]) {
                presence = true;
            }
        }
        return presence;
    }

    /**
     *
     * @param answerLetter
     * @param guessLetters
     * @return an int array of representing states:     0 - letter not present
     *                                                  1 - letter present, incorrect position
     *                                                  2 - letter present, correct position
     */
    public static int[] getJudgementArray (char[] answerLetter, char[] guessLetters) {
        // set up an int array
        int[] judgementArray = {0, 0, 0, 0, 0};

        // make copies of the arrays cuz we'll modify it
        char[] charArray = Arrays.copyOf(answerLetter, answerLetter.length);
        char[] guessLetter = Arrays.copyOf(guessLetters, guessLetters.length);

        // for loop to iterate through the guess letter array
        // this loop is for identifying those letter present and in the right position
        for (int i = 0; i < 5; i ++) {
            if (charArray[i] == guessLetter[i]) {
                charArray[i] = ' ';  // set to empty char to avoid repetition
                guessLetter[i] = '/'; // set to a non-alpha to avoid repetition
                judgementArray[i] = 2;
            }
        }

        // this loop is for identifying those letter present but not in the right position
        for (int i = 0; i < 5; i++) {
            if (presenceChar(charArray, guessLetter[i])){
                int index = 0;
                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] == guessLetter[i]){
                        index = j;
                        break;
                    }
                }
                charArray[index] = ' ';
                guessLetter[i] = '/'; // set to a non-alpha to avoid repetition
                judgementArray[i] = 1;
            }
        }

        // return the int array
        return judgementArray;
    }



//    public static void main(String[] args) {
//        char[] Arr = {'S','T','O','R','E'};
//        char[] guess = {'E','R','R','O','R'};
//        int[] result = getJudgementArray(Arr, guess);
//        System.out.println(Arrays.toString(result));
//    }

}
