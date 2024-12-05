package main;

import days.day5.Day5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String fileName = "day5.txt";
        Problem problem = new Day5();
        File inputFile = Path.of("src/main/resources/inputs/" + fileName).toFile();
        String input = Utils.readAsString(inputFile);
        problem.parseInput(input);
        logger.info("Part 1 solution: {}", problem.solvePart1());
        logger.info("Part 2 solution: {}", problem.solvePart2());
    }
}
