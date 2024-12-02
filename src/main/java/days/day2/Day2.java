package days.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.Arrays;
import java.util.List;

public class Day2 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day2.class);

    private List<List<Integer>> reports;

    public static boolean isReportSafe(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i + 1)) > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object solvePart1() {
        return reports.stream().filter(Day2::isReportSafe).count();
    }

    @Override
    public Object solvePart2() {
        return null;
    }

    @Override
    public void parseInput(String input) {
        reports = input.lines().map(this::parseReport).toList();
    }

    @Override
    public void cleanData() {

    }

    public List<Integer> parseReport(String input) {
        return Arrays.stream(input.trim().split("\\s")).map(Integer::parseInt).toList();
    }
}
