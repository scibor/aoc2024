package days.day2;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Day2Test {

    Day2 day2;
    String testData;


    @BeforeClass
    public void setup() throws IOException {
        day2 = new Day2();
        testData = Utils.readAsString(new File("src/main/resources/inputs/day2-test.txt"));
    }

    @Test
    public void isReportSafe() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        AssertionsForClassTypes.assertThat(day2.isReportSafe(list)).isTrue();
    }

}