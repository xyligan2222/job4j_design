package exam;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Keys {
    private final HashMap<String, String> map = new HashMap<>();
    /*
    method keys add in hashmap from program arguments
    example: -d=c:/ -n=*.txt -m -o=log.txt
     */

    public void keys(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("parameters do not exist");
        }
        for (String keys : args) {
            String[] strings = keys.split("[\\s =]");
            if (strings.length > 1) {
            map.put(strings[0].trim(), strings[1].trim());
            } else if (strings.length > 0) {
                map.put(strings[0].trim(), "");
            }

        }
    }
    /*
    method valid  checks validation
     */
    public boolean valid() {
        return  (map.size() > 3 && map.containsKey("-d") && map.containsKey("-n")
                && (map.containsKey("-m") || map.containsKey("-f") || map.containsKey("-r"))
                && (map.containsKey("-o")));
        }

    public String directory() {
        return map.get("-d");
    }

    public String fileName() {
        return map.get("-n");
    }

    public String maxMatch() {
        return map.get("-m");
    }

    public String regexp() {
        return map.get("-r");
    }

    public String output() {
        return map.get("-o");
    }



}
