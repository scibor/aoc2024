package days.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.List;

public class Day1 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day1.class);

    @Override
    public Object solvePart1(String input) {
        return null;
    }

    @Override
    public Object solvePart2(String input) {
        return null;
    }

    public int listDifference(List<Integer> list1, List<Integer> list2) {
        int result = 0;
        for (int i = 0; i < list1.size(); i++) {
            result += list2.get(i) - list1.get(i);
        }
        return result;
    }
}
