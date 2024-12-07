package days.day7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day7Test {

    private Day7 day7;
    private String testData;

    @BeforeMethod
    public void setUp() throws IOException {
        day7 = new Day7();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day7-test.txt"));
    }

    @Test
    public void parseEquation() {
        String input = "12739906141957: 9 4 5 55 3 5 484 86 9 5 8";
        day7.parseInput(input);
        var equation = day7.parseEquation(input);
        assertThat(equation.result()).isEqualTo(12739906141957L);
        assertThat(equation.arguments()).isEqualTo(List.of(9L, 4L, 5L, 55L, 3L, 5L, 484L, 86L, 9L, 5L, 8L));
    }
}