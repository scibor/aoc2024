package days.day5;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static days.day5.Day5Assert.assertThat;

public class Day5Test {

    private Day5 day5;
    private String testData;

    @BeforeMethod
    public void setUp() throws IOException {
        day5 = new Day5();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day5-test.txt"));
    }

    @Test
    public void testParseInput() {
        String input = """
                1|2
                1|3
                2|3
                                
                1,2,3""";

        day5.parseInput(input);
        assertThat(day5)
                .hasOnlyUpdates(List.of(1, 2, 3))
                .hasOrderingRules(Map.of(2, List.of(1), 3, List.of(1, 2)));
    }

    @Test
    public void isUpdateInCorrectOrder() {
        String input = """
                1|2
                1|3
                2|3
                                
                1,2,3""";

        day5.parseInput(input);
        AssertionsForClassTypes.assertThat(Day5.isUpdateInCorrectOrder(day5.getOrderingRules(), List.of(1, 2, 3))).isTrue();

    }

    @Test
    public void isUpdateInIncorrectOrder() {
        String input = """
                1|2
                1|3
                2|3
                                
                1,3,2""";

        day5.parseInput(input);
        AssertionsForClassTypes.assertThat(Day5.isUpdateInCorrectOrder(day5.getOrderingRules(), List.of(1, 3, 2))).isFalse();
    }

    @Test
    public void middleOfUpdate() {
        var list = List.of(1, 2, 3, 4, 5);
        AssertionsForClassTypes.assertThat(Day5.middleOfUpdate(list)).isEqualTo(3);
    }

    @Test
    public void testCase1() {
        day5.parseInput(testData);
        AssertionsForClassTypes.assertThat(day5.solvePart1()).isEqualTo(143);
    }

    @Test
    public void fixUpdate() {
        String input = """
                1|2
                1|3
                2|3
                                
                1,3,2""";

        day5.parseInput(input);
        List<Integer> update = new ArrayList<>(List.of(1, 3, 2));
        Day5.fixUpdate(day5.getOrderingRules(), update);
        AssertionsForClassTypes.assertThat(update).isEqualTo(List.of(1, 2, 3));
    }

}