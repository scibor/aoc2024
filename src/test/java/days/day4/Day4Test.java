package days.day4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day4Test {

    private Day4 day4;

    @BeforeClass
    public void setUp() {
        day4 = new Day4();
    }

    @Test
    public void padBoard1() {
        var input = new char[][]{{'a'}};
        var expected = new char[][]{
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'a', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'}
        };
        assertThat(Day4.padBoard(input)).isEqualTo(expected);
    }

    @Test
    public void padBoard2() {
        var input = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}};
        var expected = new char[][]{
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'a', 'b', 'c', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'd', 'e', 'f', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        };
        assertThat(Day4.padBoard(input)).isEqualTo(expected);
    }


}