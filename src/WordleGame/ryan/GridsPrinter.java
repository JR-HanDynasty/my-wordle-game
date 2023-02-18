package WordleGame.ryan;

public class GridsPrinter {

    /**
     * method printGrids()
     * prints the grids, letters, and judgements
     * @param guessArray
     * @param judgeArray
     * @return  None.
     */
    public static void printGrids (char[] guessArray, int[] judgeArray) {
        System.out.print("|");
        for (int i = 0; i < 5; i++) {
            if (judgeArray[i] == 0) {
                System.out.print("  " + guessArray[i] + "  |");
            } else if (judgeArray[i] == 1) {
                System.out.print(" {" + guessArray[i] + "} |");
            } else if (judgeArray[i] == 2) {
                System.out.print(" [" + guessArray[i] + "] |");
            }
        }
    }

    /**
     * method printJustGrid()
     * prints the grids for the first turn
     */
    public static void printJustGrid () {
        System.out.print("|");
        for (int i = 0; i < 5; i++) {
            System.out.print("     |");
        }
    }
}
