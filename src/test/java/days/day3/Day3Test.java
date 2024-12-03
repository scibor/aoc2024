package days.day3;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day3Test {

    private Day3 day3;

    @BeforeClass
    public void setUp() {
        day3 = new Day3();
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

    @Test(dataProvider = "mulExamples")
    public void mulParsing(String input, List<Day3.Mul> parsed) {
        var result = day3.parseMult(new Day3.ParsingResult(new ArrayList<>(), input));
        assertThat(result.parsed()).isEqualTo(parsed);
        assertThat(result.inputLeft()).isEmpty();
    }

}