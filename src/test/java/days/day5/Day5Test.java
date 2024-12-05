package days.day5;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
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

}