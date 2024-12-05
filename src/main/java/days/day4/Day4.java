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

    public int countXmases(char[][] paddedChars) {
        int count = 0;
        for (int i = 3; i < paddedChars.length - 3; i++) {
            for (int j = 3; j < paddedChars[0].length - 3; j++) {
                if (paddedChars[i][j] == 'X' && paddedChars[i][j + 1] == 'M' &&
                        paddedChars[i][j + 2] == 'A' && paddedChars[i][j + 3] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i][j - 1] == 'M' &&
                        paddedChars[i][j - 2] == 'A' && paddedChars[i][j - 3] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i + 1][j] == 'M' &&
                        paddedChars[i + 2][j] == 'A' && paddedChars[i + 3][j] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i - 1][j] == 'M' &&
                        paddedChars[i - 2][j] == 'A' && paddedChars[i - 3][j] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i + 1][j + 1] == 'M' &&
                        paddedChars[i + 2][j + 2] == 'A' && paddedChars[i + 3][j + 3] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i - 1][j - 1] == 'M' &&
                        paddedChars[i - 2][j - 2] == 'A' && paddedChars[i - 3][j - 3] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i + 1][j - 1] == 'M' &&
                        paddedChars[i + 2][j - 2] == 'A' && paddedChars[i + 3][j - 3] == 'S') {
                    count++;
                }
                if (paddedChars[i][j] == 'X' && paddedChars[i - 1][j + 1] == 'M' &&
                        paddedChars[i - 2][j + 2] == 'A' && paddedChars[i - 3][j + 3] == 'S') {
                    count++;
                }
            }
        }
        return count;
    }
}
