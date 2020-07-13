package ru.job4j.design.exercises;




import java.util.HashSet;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        HashSet<String> mapOrigin = new HashSet<>();
        HashSet<String> mapLine = new HashSet<>();
        String[] strAfterOrigin = origin.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
        for (int i = 0; i < strAfterOrigin.length; i++) {
            mapOrigin.add(strAfterOrigin[i]);
        }
        String[] strAfterLine = line.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
        /*for (int i = 0; i < strAfterLine.length; i++) {
            mapLine.add(strAfterLine[i]);
        }
        if (!mapOrigin.containsAll(mapLine)) {
            rsl = false;
        }*/
        for (int i = 0; i < strAfterLine.length; i++) {
            if (!mapOrigin.contains(strAfterLine[i])) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}