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

    public static boolean isUpdateInCorrectOrder(Map<Integer, List<Integer>> orderingRules, List<Integer> update) {
        for (int i = 0; i < update.size(); i++) {
            if (orderingRules.containsKey(update.get(i)) && i < update.size() - 1) {
                List<Integer> numbersThatShouldBeBefore = orderingRules.get(update.get(i));
                if (update.subList(i + 1, update.size()).stream().anyMatch(numbersThatShouldBeBefore::contains)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int middleOfUpdate(List<Integer> list) {
        if (list.size() % 2 == 0) {
            throw new IllegalArgumentException("Updates should be of odd length");
        }
        return list.get(list.size() / 2);
    }

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
                if (orderingRules.containsKey(to)) {
                    orderingRules.get(to).add(from);
                } else {
                    List<Integer> numbersThatAreBefore = new ArrayList<>();
                    numbersThatAreBefore.add(from);
                    orderingRules.put(to, numbersThatAreBefore);
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
