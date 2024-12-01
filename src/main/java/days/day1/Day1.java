package days.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day1 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day1.class);

    private List<Integer> list1;
    private List<Integer> list2;

    private Map<Integer, Long> list2Histogram;

    @Override
    public Object solvePart1(String input) {
        parseInput(input);
        Collections.sort(list1);
        Collections.sort(list2);
        return listDifference(list1, list2);
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
        if (numbers.length % 2 != 0) {
            logger.error("Number of numbers in the input is {} but should be even", numbers.length);
            throw new IllegalArgumentException("Number of numbers in the input should be even");
        }
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                list1.add(Integer.parseInt(numbers[i]));
            } else {
                list2.add(Integer.parseInt(numbers[i]));
            }
        }

        list2Histogram = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public Map<Integer, Long> getList2Histogram() {
        return list2Histogram;
    }
}
