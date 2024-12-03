package main;

import days.day3.Day3;
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
        String fileName = "day3.txt";
        Problem problem = new Day3();
        File inputFile = Path.of("src/main/resources/inputs/" + fileName).toFile();
        String input = Utils.readAsString(inputFile);
        problem.parseInput(input);
        logger.info("Part 1 solution: {}", problem.solvePart1());
        logger.info("Part 2 solution: {}", problem.solvePart2());
    }
}
