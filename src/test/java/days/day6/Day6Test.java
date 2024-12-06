package days.day6;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Direction;
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

        day6.parseInput(input);
        assertThat(day6.getGuardDirection()).isEqualTo(Direction.N);
        compare2DArray(day6.getMap(), expected);
        compare2DArray(day6.getVisited(), new boolean[4][5]);
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