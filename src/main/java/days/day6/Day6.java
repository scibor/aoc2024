package days.day6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.Problem;
import utils.Direction;
import utils.Point2D;

import java.util.Arrays;
import java.util.List;

import static utils.Direction.*;

public class Day6 implements Problem {

    private static final Logger logger = LoggerFactory.getLogger(Day6.class);
    private MapElement[][] map;
    private Direction guardDirection;
    private Point2D guardLocation;
    private Point2D originalGuardLocation;
    private boolean[][] visited;

    @Override
    public Object solvePart1() {
        int steps = 0;
        while (this.makeStep()) {
            steps++;
        }
        logger.debug("Steps: {}", steps);
        int result = 0;
        for (boolean[] row : visited) {
            for (int j = 0; j < visited[0].length; j++) {
                if (row[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public Object solvePart2() {
        int loopingCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                guardDirection = N;
                guardLocation = originalGuardLocation;
                logger.debug("Modifying at ({},{})", i, j);
                MapElement[][] modifiedMap;
                if (map[i][j].equals(MapElement.EMPTY)) {
                    modifiedMap = copyWithModification(map, i, j);
                } else {
                    continue;
                }
                int numberOfSteps = 0;
                while (makeStep(modifiedMap)) {
                    numberOfSteps++;
                    if (numberOfSteps > modifiedMap.length * modifiedMap[0].length * 4) {
                        loopingCount++;
                        logger.debug("Number of steps: {}", numberOfSteps);
                        logger.debug("Found possible obstacle placement: ({},{})", i, j);
                        break;
                    }
                }
            }
        }
        return loopingCount;
    }

    private boolean makeStep(MapElement[][] modifiedMap) {
        int i = guardLocation.y();
        int j = guardLocation.x();
        int newI = -1;
        int newJ = -1;
        switch (guardDirection) {
            case N -> {
                newI = i - 1;
                newJ = j;
            }
            case S -> {
                newI = i + 1;
                newJ = j;
            }
            case E -> {
                newI = i;
                newJ = j + 1;
            }
            case W -> {
                newI = i;
                newJ = j - 1;
            }
        }
        if (newI < 0 || newJ < 0 || newI >= modifiedMap.length || newJ >= modifiedMap[0].length) {
            return false;
        }
        if (modifiedMap[newI][newJ].equals(MapElement.EMPTY)) {
            guardLocation = new Point2D(newI, newJ);
            visited[newI][newJ] = true;
            modifiedMap[i][j] = MapElement.EMPTY;
            modifiedMap[newI][newJ] = MapElement.GUARD;
        } else {
            guardDirection = turnGuard(guardDirection);
            makeStep(modifiedMap);
        }

        return true;
    }

    public MapElement[][] copyWithModification(MapElement[][] original, int i, int j) {
        MapElement[][] copy = new MapElement[original.length][];
        for (int k = 0; k < original.length; k++) {
            copy[k] = Arrays.copyOf(original[k], original[k].length);
        }
        copy[i][j] = MapElement.OBSTACLE;
        return copy;
    }

    @Override
    public void parseInput(String input) {
        List<String> lines = input.lines().map(String::trim).toList();
        int height = lines.size();
        int width = lines.getFirst().length();
        visited = new boolean[height][width];
        map = new MapElement[height][width];
        guardDirection = N;
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
                if (mapElement.equals(MapElement.GUARD)) {
                    visited[i][j] = true;
                    guardLocation = new Point2D(i, j);
                    originalGuardLocation = new Point2D(i, j);
                }
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

    public Point2D getGuardLocation() {
        return guardLocation;
    }

    public boolean makeStep() {
        int i = guardLocation.y();
        int j = guardLocation.x();
        int newI = -1;
        int newJ = -1;
        switch (guardDirection) {
            case N -> {
                newI = i - 1;
                newJ = j;
            }
            case S -> {
                newI = i + 1;
                newJ = j;
            }
            case E -> {
                newI = i;
                newJ = j + 1;
            }
            case W -> {
                newI = i;
                newJ = j - 1;
            }
        }
        if (newI < 0 || newJ < 0 || newI >= map.length || newJ >= map[0].length) {
            map[i][j] = MapElement.EMPTY;
            map[originalGuardLocation.y()][originalGuardLocation.x()] = MapElement.GUARD;
            return false;
        }
        if (map[newI][newJ].equals(MapElement.EMPTY)) {
            guardLocation = new Point2D(newI, newJ);
            visited[newI][newJ] = true;
            map[i][j] = MapElement.EMPTY;
            map[newI][newJ] = MapElement.GUARD;
        } else {
            guardDirection = turnGuard(guardDirection);
            makeStep();
        }

        return true;
    }

    public Direction turnGuard(Direction direction) {
        return switch (direction) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public int directionToNumber(Direction direction) {
        return switch (direction) {
            case N -> 1;
            case S -> 2;
            case W -> 3;
            case E -> 4;
        };
    }
}