package days.day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.List;

public class Day3 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day3.class);

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

    public ParsingResult parseMult(ParsingResult input) {
        String toParse = input.inputLeft;
        List<Mul> alreadyParsed = input.parsed;

        int index = toParse.indexOf("mul(");

        if (index < 0) {
            return new ParsingResult(alreadyParsed, "");
        }

        index += 4;

        char currentChar = toParse.charAt(index);
        StringBuilder firstArgument = new StringBuilder();
        while (Character.isDigit(currentChar)) {
            firstArgument.append(currentChar);
            index++;
            currentChar = toParse.charAt(index);
        }

        if (currentChar != ',') {
            return parseMult(new ParsingResult(alreadyParsed, toParse.substring(index)));
        }

        index++;
        currentChar = toParse.charAt(index);
        StringBuilder secondArgument = new StringBuilder();
        while (Character.isDigit(currentChar)) {
            secondArgument.append(currentChar);
            index++;
            currentChar = toParse.charAt(index);
        }

        if (currentChar != ')') {
            return parseMult(new ParsingResult(alreadyParsed, toParse.substring(index)));
        }

        alreadyParsed.add(new Mul(Long.parseLong(firstArgument.toString()), Long.parseLong(secondArgument.toString())));
        return parseMult(new ParsingResult(alreadyParsed, toParse.substring(index)));
    }

    public record Mul(long x, long y) {
        public long evaluate() {
            return x * y;
        }
    }

    public record ParsingResult(List<Mul> parsed, String inputLeft) {
    }
}
