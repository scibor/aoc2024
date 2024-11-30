package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Utils {
    public static String readAsString(File input) throws IOException {
        return Files.readString(input.toPath());
    }
}
