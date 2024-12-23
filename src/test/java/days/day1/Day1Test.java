package days.day1;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
        AssertionsForInterfaceTypes.assertThat(day1.getList1()).isEqualTo(List.of(1, 2));
        AssertionsForInterfaceTypes.assertThat(day1.getList2()).isEqualTo(List.of(3, 4));
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
        day1.parseInput(testData);
        assertThat(day1.solvePart1()).isEqualTo(11);
    }

    @Test
    public void simpleHistogramFromList2() {
        var data = """
                1   3
                1   1
                1   3""";
        day1.parseInput(data);
        AssertionsForInterfaceTypes.assertThat(day1.getList2Histogram()).containsEntry(1, 1L).containsEntry(3, 2L);
    }

    @Test
    public void similarityScore() {
        var list = List.of(1, 3, 1);
        var histogram = Map.of(1, 1L, 3, 2L);
        assertThat(day1.similarityScore(list, histogram)).isEqualTo(8);
    }

    @Test
    public void similarityScoreWithValueOutsideHistogram() {
        var list = List.of(1, 2, 1);
        var histogram = Map.of(1, 1L, 3, 2L);
        assertThat(day1.similarityScore(list, histogram)).isEqualTo(2);
    }

    @Test
    public void testCasePart2() {
        day1.parseInput(testData);
        assertThat(day1.solvePart2()).isEqualTo(31L);
    }

}