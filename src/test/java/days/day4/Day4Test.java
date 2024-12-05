package days.day4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day4Test {

    private Day4 day4;
    private String testData;

    @BeforeClass
    public void setUp() throws IOException {
        day4 = new Day4();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day4-test.txt"));
    }

    @Test
    public void padBoard1() {
        var input = new char[][]{{'a'}};
        var expected = new char[][]{
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'a', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'}
        };
        assertThat(Day4.padBoard(input)).isEqualTo(expected);
    }

    @Test
    public void padBoard2() {
        var input = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}};
        var expected = new char[][]{
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'a', 'b', 'c', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'd', 'e', 'f', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        };
        assertThat(Day4.padBoard(input)).isEqualTo(expected);
    }

    @Test
    public void countXmases() {
        var input = new char[][]{{'X', 'M', 'A', 'S'}};
        assertThat(day4.countXmases(Day4.padBoard(input))).isEqualTo(1);
    }

    @Test
    public void countXmases2() {
        var input = new char[][]{
                {'S', 'X', 'X', 'S', 'X', 'X', 'S'},
                {'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                {'X', 'X', 'M', 'M', 'M', 'X', 'X'},
                {'S', 'A', 'M', 'X', 'M', 'A', 'S'},
                {'X', 'X', 'M', 'M', 'M', 'X', 'X'},
                {'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                {'S', 'X', 'X', 'S', 'X', 'X', 'S'},
        };
        assertThat(day4.countXmases(Day4.padBoard(input))).isEqualTo(8);
    }

    @Test
    public void testCasePart1() {
        day4.parseInput(testData);
        assertThat(day4.solvePart1()).isEqualTo(18);
    }

    @Test
    public void countMases() {
        var input = new char[][]{
                {'M', 'X', 'S', 'X', 'M', 'X', 'M'},
                {'X', 'A', 'X', 'X', 'X', 'A', 'X'},
                {'M', 'X', 'S', 'X', 'S', 'X', 'S'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'S', 'X', 'M', 'X', 'S', 'X', 'S'},
                {'X', 'A', 'X', 'X', 'X', 'A', 'X'},
                {'S', 'X', 'M', 'X', 'M', 'X', 'M'}
        };
        assertThat(day4.countMases(Day4.padBoard(input))).isEqualTo(4);
    }
}