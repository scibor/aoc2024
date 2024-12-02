package days.day2;

import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Day2Test {

    Day2 day2;
    String testData;


    @DataProvider(name = "isReportMonotone")
    public static Object[][] lists2() {
        return new Object[][]{
                {List.of(1, 2, 3, 4, 5), true},
                {List.of(1, 2, 3, 4, 4), false},
                {List.of(1, 2, 3, 4, 3), false},
                {List.of(7, 6, 4, 3, 1), true},
                {List.of(7, 6, 4, 3, 3), false},
                {List.of(7, 6, 4, 3, 5), false},
                {List.of(), true}
        };
    }

    @DataProvider(name = "listWithoutElement")
    public static Object[][] listWithoutElement() {
        return new Object[][]{
                {List.of(1, 2, 3, 4, 5), 1, List.of(1, 3, 4, 5)},
                {List.of(1, 2, 3, 4, 5), 3, List.of(1, 2, 3, 5)},
                {List.of(1, 2, 3, 4, 5), 0, List.of(2, 3, 4, 5)},
                {List.of(1, 2, 3, 4, 5), 4, List.of(1, 2, 3, 4)},
        };
    }

    @DataProvider(name = "isReportSafe")
    public static Object[][] lists() {
        return new Object[][]{
                {List.of(1, 2, 3, 4, 5), true},
                {List.of(1, 3, 4, 6, 7), true},
                {List.of(7, 6, 4, 3, 1), true},
                {List.of(5, 4, 3, 2, 1), true},
                {List.of(1, 2, 5), true},
                {List.of(1, 2, 6), false},
                {List.of(1, 2, 1), false},
                {List.of(), true}
        };
    }

    @BeforeClass
    public void setup() throws IOException {
        day2 = new Day2();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day2-test.txt"));
    }

    @Test(dataProvider = "isReportMonotone")
    public void isReportMonotone(List<Integer> list, boolean result) {
        AssertionsForClassTypes.assertThat(Day2.isReportMonotone(list)).isEqualTo(result);
    }

    @Test(dataProvider = "isReportSafe")
    public void isReportSafe(List<Integer> list, boolean result) {
        AssertionsForClassTypes.assertThat(Day2.isReportSafe(list)).isEqualTo(result);
    }

    @Test
    public void parseReport() {
        String input = "1 2 3 4 5";
        AssertionsForInterfaceTypes.assertThat(day2.parseReport(input)).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @Test
    public void testCasePart1() {
        day2.parseInput(testData);
        AssertionsForClassTypes.assertThat(day2.solvePart1()).isEqualTo(2L);
    }
    @Test(dataProvider = "listWithoutElement")
    public void listWithoutElement(List<Integer> list, int index, List<Integer> result) {
        AssertionsForClassTypes.assertThat(Day2.listWithoutElement(list, index)).isEqualTo(result);
    }
}