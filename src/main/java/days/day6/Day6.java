package days.day6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;
import utils.Direction;

import java.util.List;

public class Day6 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day6.class);
    private MapElement[][] map;
    private Direction guardDirection;
    private boolean[][] visited;

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
        List<String> lines = input.lines().map(String::trim).toList();
        int height = lines.size();
        int width = lines.getFirst().length();
        visited = new boolean[height][width];
        map = new MapElement[height][width];
        guardDirection = Direction.N;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                char currentChar = line.charAt(j);
                MapElement mapElement = switch (currentChar) {
                    case '.' -> MapElement.EMPTY;
                    case '#' -> MapElement.OBSTACLE;
                    case '^' -> MapElement.GUARD;
                    default ->
                            throw new IllegalArgumentException("Character should be '.', '#' or '^' but instead was: " + currentChar);
                };
                map[i][j] = mapElement;
            }
        }
    }

    @Override
    public void cleanData() {

    }

    public MapElement[][] getMap() {
        return map;
    }

    public Direction getGuardDirection() {
        return guardDirection;
    }

    public boolean[][] getVisited() {
        return visited;
    }
}