package days.day7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public boolean isEquationSolvable(Equation equation) {
        List<Long> possibleAnswers = new ArrayList<>();
        for (long x : equation.arguments()) {
            if (possibleAnswers.isEmpty()) {
                possibleAnswers.add(x);
                continue;
            }
            possibleAnswers = possibleAnswers.stream().flatMap(y -> Stream.of(y + x, y * x)).collect(Collectors.toList());
        }
        return possibleAnswers.contains(equation.result());
    }
}
