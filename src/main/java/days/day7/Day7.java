package days.day7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.Arrays;
import java.util.List;

public class Day7 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day7.class);

    @Override
    public Object solvePart1() {
        return null;
    }

    @Override
    public Object solvePart2() {
        return null;
    }

    @Override
    public void parseInput(String input) {

    }

    @Override
    public void cleanData() {

    }

    public Equation parseEquation(String input) {
        String[] split = input.split(":");
        long result = Long.parseLong(split[0]);
        List<Long> arguments = Arrays.stream(split[1].trim().split(" ")).map(Long::parseLong).toList();
        return new Equation(result, arguments);
    }
}
