package days.day1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Day1Test {

    Day1 day1;
    String testData;

    @BeforeClass
    public void setup() throws IOException {
        day1 = new Day1();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day1-test.txt"));
    }

    @Test
    public void listDifferenceForSameLists() {
        var list1 = List.of(1, 2, 3, 4, 5);
        assertThat(day1.listDifference(list1, list1)).isZero();
    }

    @Test
    public void listDifferenceForDifferentLists() {
        var list1 = List.of(1, 2, 3, 4, 5);
        var list2 = List.of(11, 12, 13, 14, 15);
        assertThat(day1.listDifference(list1, list2)).isEqualTo(50);
    }

    @Test
    public void listDifferenceForListsOfDifferentLengths1() {
        var list1 = List.of(1, 2, 3, 4, 5);
        var list2 = List.of(11, 12, 13, 14);
        assertThatThrownBy(() -> day1.listDifference(list1, list2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void listDifferenceForListsOfDifferentLengths2() {
        var list1 = List.of(1, 2, 3);
        var list2 = List.of(11, 12, 13, 14);
        assertThatThrownBy(() -> day1.listDifference(list1, list2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void listDifferenceShouldBePositive() {
        var list1 = List.of(1, 2, 3, 4, 5);
        var list2 = List.of(11, 12, 13, 14, 15);
        assertThat(day1.listDifference(list2, list1)).isEqualTo(50);
    }

    @Test
    public void readSimpleData() {
        var data = """
                1   3
                2   4""";
        day1.parseInput(data);
        Day1Assert.assertThat(day1).hasList1(1, 2).hasList2(3, 4);
    }

    @Test
    public void readingMalformedData() {
        var data = """
                1   3
                2 """;
        assertThatThrownBy(() -> day1.parseInput(data)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCasePart1() {
        assertThat(day1.solvePart1(testData)).isEqualTo(11);
    }
}