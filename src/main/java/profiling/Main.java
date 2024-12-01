package profiling;

import days.day1.Day1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        logger.info("Starting profiling");
        String fileName = "day1.txt";
        Problem problem = new Day1();
        File inputFile = Path.of("src/main/resources/inputs/" + fileName).toFile();
        String input = Utils.readAsString(inputFile);
        Instant end = Instant.now().plus(1, ChronoUnit.MINUTES);
        int runs = 0;
        while (Instant.now().isBefore(end)) {
            problem.parseInput(input);
            problem.solvePart1();
            problem.solvePart2();
            problem.cleanData();
            runs++;
        }
        logger.info("Number of iterations in a minute: {}", runs);
        logger.info("Profiling ended");
    }
}
