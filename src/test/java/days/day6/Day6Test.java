package days.day6;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Direction;
import utils.Point2D;
import utils.Utils;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day6Test {


    private Day6 day6;
    private String testData;

    @BeforeMethod
    public void setUp() throws IOException {
        day6 = new Day6();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day6-test.txt"));
    }

    @Test
    public void testParseInput() {
        String input = """
                ..#..
                .....
                ..^..
                .....""";

        MapElement[][] expected = new MapElement[][]{
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.OBSTACLE, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.GUARD, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY}
        };

        boolean[][] expectedVisited = new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false}
        };

        day6.parseInput(input);
        assertThat(day6.getGuardDirection()).isEqualTo(Direction.N);
        compare2DArray(day6.getMap(), expected);
        compare2DArray(day6.getVisited(), expectedVisited);
        assertThat(day6.getGuardLocation()).isEqualTo(new Point2D(2, 2));
    }

    @Test
    public void makeSingleStep() {
        String input = """
                ..#..
                .....
                ..^..
                .....""";

        MapElement[][] expected = new MapElement[][]{
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.OBSTACLE, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.GUARD, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY}
        };

        boolean[][] expectedVisited = new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false}
        };
        day6.parseInput(input);
        boolean possible = day6.makeStep();
        assertThat(possible).isTrue();
        assertThat(day6.getMap()).isEqualTo(expected);
        assertThat(day6.getVisited()).isEqualTo(expectedVisited);
        assertThat(day6.getGuardDirection()).isEqualTo(Direction.N);
        assertThat(day6.getGuardLocation()).isEqualTo(new Point2D(1, 2));
    }

    @Test
    public void makeStepWithTurn() {
        String input = """
                ..#..
                .....
                ..^..
                .....""";

        MapElement[][] expected = new MapElement[][]{
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.OBSTACLE, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.GUARD, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY}
        };

        boolean[][] expectedVisited = new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, true, false},
                {false, false, true, false, false},
                {false, false, false, false, false}
        };
        day6.parseInput(input);
        boolean possible = day6.makeStep();
        assertThat(possible).isTrue();
        possible = day6.makeStep();
        assertThat(possible).isTrue();
        assertThat(day6.getMap()).isEqualTo(expected);
        assertThat(day6.getVisited()).isEqualTo(expectedVisited);
        assertThat(day6.getGuardDirection()).isEqualTo(Direction.E);
        assertThat(day6.getGuardLocation()).isEqualTo(new Point2D(1, 3));
    }

    @Test
    public void stepOffTheBoard() {
        String input = "^";
        day6.parseInput(input);
        boolean possible = day6.makeStep();
        assertThat(possible).isFalse();
    }

    @Test
    public void testCasePart1() {
        day6.parseInput(testData);
        assertThat(day6.solvePart1()).isEqualTo(41);
    }

    @Test
    public void testCasePart2() {
        day6.parseInput(testData);
        assertThat(day6.solvePart2()).isEqualTo(6);
    }

    @Test
    public void copyWithModification() {
        MapElement[][] original = new MapElement[][]{
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.OBSTACLE, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.GUARD, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY}
        };

        MapElement[][] expected = new MapElement[][]{
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.OBSTACLE, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.OBSTACLE, MapElement.EMPTY, MapElement.GUARD, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY},
                {MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY, MapElement.EMPTY}
        };

        compare2DArray(day6.copyWithModification(original, 1, 1), expected);
    }

    private <T> void compare2DArray(T[][] a1, T[][] a2) {
        assertThat(a1.length).as("Arrays height should be the same").isEqualTo(a2.length);
        assertThat(a1[0].length).as("Arrays width should be the same").isEqualTo(a2[0].length);
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                assertThat(a1[i][j]).as(String.format("Values at (%d,%d) should be the same", j, i)).isEqualTo(a2[i][j]);
            }
        }
    }

    private <T> void compare2DArray(boolean[][] a1, boolean[][] a2) {
        assertThat(a1.length).as("Arrays height should be the same").isEqualTo(a2.length);
        assertThat(a1[0].length).as("Arrays width should be the same").isEqualTo(a2[0].length);
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                assertThat(a1[i][j]).as(String.format("Values at (%d,%d) should be the same", j, i)).isEqualTo(a2[i][j]);
            }
        }
    }


}