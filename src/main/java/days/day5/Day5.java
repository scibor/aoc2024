package days.day5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;

import java.util.*;
import java.util.stream.Collectors;

public class Day5 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day5.class);

    private final Map<Integer, List<Integer>> orderingRules = new HashMap<>();
    private final List<List<Integer>> updates = new ArrayList<>();

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
        List<String> lines = input.lines().toList();
        boolean parsingRules = true;
        for (String line : lines) {
            if (line.isEmpty()) {
                parsingRules = false;
                continue;
            }
            if (parsingRules) {
                String[] split = line.trim().split("\\|");
                int from = Integer.parseInt(split[0]);
                int to = Integer.parseInt(split[1]);
                if (orderingRules.containsKey(from)) {
                    orderingRules.get(from).add(to);
                } else {
                    List<Integer> numbersThatAreAfter = new ArrayList<>();
                    numbersThatAreAfter.add(to);
                    orderingRules.put(from, numbersThatAreAfter);
                }
            } else {
                List<Integer> update = Arrays.stream(line.trim().split(",")).map(Integer::parseInt).collect(Collectors.toList());
                updates.add(update);
            }
        }
    }

    @Override
    public void cleanData() {

    }

    public List<List<Integer>> getUpdates() {
        return updates;
    }

    public Map<Integer, List<Integer>> getOrderingRules() {
        return orderingRules;
    }
}
