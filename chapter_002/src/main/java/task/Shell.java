package task;


import java.util.ArrayList;

public class Shell {
    ArrayList<String> arrayList = new ArrayList<>();
    String root = "/";

    public void cd(String path) {
        if (path.equals(root)) {
            arrayList.add(root);
        } else {
            String[] strings = path.split("/");
            if (strings.length == 0) {
                throw new NullPointerException("The path must not be empty");
            }
            arrayList.add(root);
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals("..") && arrayList.size() > 1) {
                    arrayList.remove(arrayList.size()-1);
                    arrayList.remove(arrayList.size()-1);

                } else if (!strings[i].equals("..")) {
                    arrayList.add(strings[i]);
                }
            }
        }
    }

    public String pwd() {
        return arrayList.toString().replace("[", "").replace("]", "")
                .replace(",", "").replaceAll(" ", "");

    }

}