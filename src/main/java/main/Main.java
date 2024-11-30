package main;

import days.day1.Day1;
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
        String fileName = "day1.txt";
        Problem problem = new Day1();
        File inputFile = Path.of("src/main/resources/inputs/" + fileName).toFile();
        String input = Utils.readAsString(inputFile);
        logger.info("Part 1 solution: {}", problem.solvePart1(input));
        logger.info("Part 2 solution: {}", problem.solvePart2(input));
    }
}
