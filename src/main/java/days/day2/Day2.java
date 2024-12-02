package days.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day2 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day2.class);

    private List<List<Integer>> reports;

    public static boolean isReportSafe(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i + 1)) > 3) {
                return false;
            }
        }
        return isReportMonotone(list);
    }

    public static boolean isReportMonotone(List<Integer> list) {
        boolean increasing = true;
        if (list.size() < 2) {
            return true;
        }
        if (list.get(0) > list.get(1)) {
            increasing = false;
        } else if (Objects.equals(list.get(0), list.get(1))) {
            return false;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (increasing && list.get(i) >= list.get(i + 1) || !increasing && list.get(i) <= list.get(i + 1))
                return false;
        }
        return true;
    }

    public static boolean isReportMonotoneWithDampener(List<Integer> list) {
        boolean increasing = true;
        if (list.size() < 2) {
            return true;
        }
        if (isReportMonotone(listWithoutElement(list, 0)) || isReportMonotone(listWithoutElement(list, 1))) {
            return true;
        }
        if (list.get(0) > list.get(1)) {
            increasing = false;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (increasing && list.get(i) >= list.get(i + 1) || !increasing && list.get(i) <= list.get(i + 1))
                return isReportMonotone(listWithoutElement(list, i)) || isReportMonotone(listWithoutElement(list, i + 1));
        }
        return true;
    }

    public static List<Integer> listWithoutElement(List<Integer> list, int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == index) continue;
            result.add(list.get(i));
        }
        return result;
    }

    public static boolean isReportSafeWithDampener(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i + 1)) > 3) {
                return isReportSafe(listWithoutElement(list, i)) || isReportSafe(listWithoutElement(list, i + 1));
            }
        }
        return isReportMonotoneWithDampener(list);
    }

    @Override
    public Object solvePart1() {
        return reports.stream().filter(Day2::isReportSafe).count();
    }

    @Override
    public Object solvePart2() {
        return reports.stream().filter(Day2::isReportSafeWithDampener).count();
    }

    @Override
    public void parseInput(String input) {
        reports = input.lines().map(this::parseReport).toList();
    }

    @Override
    public void cleanData() {
    }

    public List<Integer> parseReport(String input) {
        return Arrays.stream(input.trim().split(" ")).map(Integer::parseInt).toList();
    }
}
