package days.day1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Day1Test {

    Day1 day1;

    @BeforeClass
    public void setup() {
        day1 = new Day1();
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


}