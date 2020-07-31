package exam;

import java.nio.file.Path;
import java.util.function.Predicate;

public class ConditionFactory {

    public static Predicate<Path> preparePredicate(Keys keys) {
        if (!keys.fileName().equals("")) {
            return path -> path.toFile().getName().toLowerCase().equals(keys.fileName().toLowerCase());
        } else {
            if (!keys.maxMatch().equals("")) {
                return prepareMask(keys.maxMatch());
            } else {
                return path -> path.toFile().getName().matches(keys.regexp());
            }
        }
    }

    private static Predicate<Path> prepareMask(String mask) {
        String[] searcher = mask.split("\\.");
        if (searcher[0].equals("*")) {
            return path -> path.toFile().getName().endsWith(searcher[1]);
        } else {
            if (searcher[1].equals("*")) {
                return path -> path.toFile().getName().startsWith(searcher[0]);
            } else {
                return path -> path.toFile().getName().toLowerCase().equals(mask.toLowerCase());
            }
        }

    }
}
