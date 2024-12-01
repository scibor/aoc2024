package days.day1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

}