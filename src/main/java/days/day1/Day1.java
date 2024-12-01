package days.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.ArrayList;
import java.util.List;

public class Day1 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day1.class);

    private List<Integer> list1;
    private List<Integer> list2;

    @Override
    public Object solvePart1(String input) {
        return null;
    }

    @Override
    public Object solvePart2(String input) {
        return null;
    }

    public int listDifference(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            logger.error("Lists {} and {} should be of same length, but they lengths are {} and {}", list1, list2, list1.size(), list2.size());
            throw new IllegalArgumentException("Lists should be the same length");
        }
        int result = 0;
        for (int i = 0; i < list1.size(); i++) {
            result += Math.abs(list2.get(i) - list1.get(i));
        }
        return result;
    }

    public void parseInput(String data) {
        String[] numbers = data.split("\\s+");
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                list1.add(Integer.parseInt(numbers[i]));
            } else {
                list2.add(Integer.parseInt(numbers[i]));
            }
        }
    }

    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }
}
