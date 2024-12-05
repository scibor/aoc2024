package days.day4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

public class Day4 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day4.class);

    public static char[][] padBoard(char[][] board) {
        int newWidth = board[0].length + 6;
        int newHeight = board.length + 6;

        var result = new char[newHeight][newWidth];
        for (int i = 0; i < newWidth; i++) {
            for (int j = 0; j < newHeight; j++) {
                if (i < 3 || i >= board[0].length + 3 || j < 3 || j >= board.length + 3) {
                    result[j][i] = 'O';
                } else {
                    result[j][i] = board[j - 3][i - 3];
                }
            }
        }
        return result;
    }

    @Override
    public Object solvePart1() {
        return null;
    }

    @Override
    public Object solvePart2() {
        return null;
    }

    @Override
    public void parseInput(String input) {

    }

    @Override
    public void cleanData() {

    }
}
