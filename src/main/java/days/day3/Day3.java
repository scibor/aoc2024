package days.day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.ArrayList;
import java.util.List;

public class Day3 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day3.class);
    private String input;

    @Override
    public Object solvePart1() {
        return parseMul(new ParsingResult(new ArrayList<>(), input))
                .parsed
                .stream()
                .mapToLong(Mul::evaluate)
                .sum();
    }

    @Override
    public Object solvePart2() {
        return parseMulWithConditionals(new ParsingWithConditionalsResult(new ArrayList<>(), input, true))
                .parsed
                .stream()
                .mapToLong(Mul::evaluate)
                .sum();
    }

    @Override
    public void parseInput(String input) {
        this.input = input;
    }

    @Override
    public void cleanData() {

    }

    public ParsingResult parseMul(ParsingResult input) {
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
            return parseMul(new ParsingResult(alreadyParsed, toParse.substring(index)));
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
            return parseMul(new ParsingResult(alreadyParsed, toParse.substring(index)));
        }

        alreadyParsed.add(new Mul(Long.parseLong(firstArgument.toString()), Long.parseLong(secondArgument.toString())));
        return parseMul(new ParsingResult(alreadyParsed, toParse.substring(index)));
    }

    public ParsingWithConditionalsResult parseMulWithConditionals(ParsingWithConditionalsResult parsingResult) {
        String toParse = parsingResult.inputLeft;
        List<Mul> alreadyParsed = parsingResult.parsed;
        boolean enabled = parsingResult.enabled;

        int index = toParse.indexOf("mul(");
        int dontIndex = toParse.indexOf("don't()");
        int doIndex = toParse.indexOf("do()");

        if (index < 0) {
            return new ParsingWithConditionalsResult(alreadyParsed, "", enabled);
        }

        if (enabled && dontIndex >= 0 && dontIndex < index) {
            return parseMulWithConditionals(new ParsingWithConditionalsResult(alreadyParsed, toParse.substring(dontIndex + 6), false));
        }

        if (!enabled) {
            if (doIndex < 0) {
                return new ParsingWithConditionalsResult(alreadyParsed, "", false);
            } else {
                return parseMulWithConditionals(new ParsingWithConditionalsResult(alreadyParsed, toParse.substring(doIndex + 4), true));
            }
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
            return parseMulWithConditionals(new ParsingWithConditionalsResult(alreadyParsed, toParse.substring(index), true));
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
            return parseMulWithConditionals(new ParsingWithConditionalsResult(alreadyParsed, toParse.substring(index), true));
        }

        alreadyParsed.add(new Mul(Long.parseLong(firstArgument.toString()), Long.parseLong(secondArgument.toString())));
        return parseMulWithConditionals(new ParsingWithConditionalsResult(alreadyParsed, toParse.substring(index), true));
    }

    public record Mul(long x, long y) {
        public long evaluate() {
            return x * y;
        }
    }

    public record ParsingResult(List<Mul> parsed, String inputLeft) {
    }

    public record ParsingWithConditionalsResult(List<Mul> parsed, String inputLeft, boolean enabled) {
    }
}
