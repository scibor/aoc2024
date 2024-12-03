package days.day3;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day3Test {

    private Day3 day3;
    private String testData;
    private String testDataPart2;

    @BeforeClass
    public void setUp() throws IOException {
        day3 = new Day3();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day3-test.txt"));
        testDataPart2 = Utils.readAsString(new File("src/main/resources/inputs/day3-test2.txt"));
    }

    @DataProvider(name = "mulExamples")
    public Object[][] mulExamples() {
        return new Object[][]{
                {"mul(1,2)", List.of(new Day3.Mul(1, 2))},
                {"aaamul(1,2)", List.of(new Day3.Mul(1, 2))},
                {"aaamul(1,2)bbbb", List.of(new Day3.Mul(1, 2))},
                {"aaamul(1,2)bmubmul(5,2)bb", List.of(new Day3.Mul(1, 2), new Day3.Mul(5, 2))},
                {"", List.of()}
        };
    }

    @DataProvider(name = "mulWithConditionals")
    public Object[][] mulWithConditionals() {
        return new Object[][]{
                {"mul(1,2)", List.of(new Day3.Mul(1, 2))},
                {"don't()mul(1,2)", List.of()},
                {"mul(1,2)don't()mul(4,2)do()mul(3,1)", List.of(new Day3.Mul(1, 2), new Day3.Mul(3, 1))},
        };
    }

    @Test(dataProvider = "mulExamples")
    public void mulParsing(String input, List<Day3.Mul> parsed) {
        var result = day3.parseMul(new Day3.ParsingResult(new ArrayList<>(), input));
        assertThat(result.parsed()).isEqualTo(parsed);
        assertThat(result.inputLeft()).isEmpty();
    }

    @Test
    public void testCasePart1() {
        day3.parseInput(testData);
        assertThat(day3.solvePart1()).isEqualTo(161L);
    }

    @Test(dataProvider = "mulWithConditionals")
    public void mulWithConditionals(String input, List<Day3.Mul> parsed) {
        var result = day3.parseMulWithConditionals(new Day3.ParsingWithConditionalsResult(new ArrayList<>(), input, true));
        assertThat(result.parsed()).isEqualTo(parsed);
        assertThat(result.inputLeft()).isEmpty();
    }

    @Test
    public void testCasePart2() {
        day3.parseInput(testDataPart2);
        assertThat(day3.solvePart2()).isEqualTo(48L);
    }
}