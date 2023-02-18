package WordleGame.ryan;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {

        // create new answer word instance
        AnswerWord word = new AnswerWord();

        // welcome the user
        System.out.println();
        System.out.println("Welcome to Wordle in the style of New York Times!");
        System.out.println("Rules: guess the 5 letter word in 6 turns.");
        System.out.println("       \"[ ]\" means the letter presents and is at the right position.");
        System.out.println("       \"{ }\" means the letter presents but is NOT at the right position.");
        System.out.println();
        System.out.println("--------------------------------GAME-NOW-STARTS---------------------------------");
        System.out.println();
        // System.out.println(Arrays.toString(word.getAnswerWordArray()));

        boolean win = false;
        int turns = 0;
        System.out.print("          ");
        System.out.print(" Begin:  ");
        GridsPrinter.printJustGrid();

        for (; turns < 6; turns++) {
            PlayerWord myGuess = new PlayerWord();
            System.out.print(" Turn " + (turns + 1) + ": ");
            GridsPrinter.printGrids(myGuess.getUserInputArray(), Judgement.getJudgementArray(word.getAnswerWordArray(), myGuess.getUserInputArray()));

            // for each loop to check if the user had won or not
            win = true;
            for (int digit : Judgement.getJudgementArray(word.getAnswerWordArray(), myGuess.getUserInputArray())) {
                if (digit != 2) {
                    win = false;
                }
            }
            if (win) {
                System.out.println("  You've guessed the word in " + (turns + 1) + " turns. Well done");
                System.out.println();
                System.out.println("--------------------------------GAME-NOW-ENDS-----------------------------------");
                break;
            }
        }
        if (!win) {
            System.out.println("  You've used up all turns");
            System.out.println();
            System.out.println("The answer is " + word.answer.toUpperCase() + ". Better luck next time");
            System.out.println();
            System.out.println("--------------------------------GAME-NOW-ENDS-----------------------------------");
        }
    }
}