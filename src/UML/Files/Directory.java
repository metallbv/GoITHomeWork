package UML.Files;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Directory {

    private String name; // Path to directory
    private ArrayList<File> files = new ArrayList<File>(); // List of files in directory
    private static String illegalChars = "*?\"<>|||";
    private static Set<Character> setIllegalChars = new HashSet<>();

    static {
        for (int i = 0; i < illegalChars.length(); i++) {
            setIllegalChars.add(illegalChars.charAt(i));
        }
    }

    public Directory(String name){

        if (isNameCorrect(name)) {
        this.name = name;
        } else {
            throw new IllegalArgumentException("Error: path name consist illegal symbol");
        }

    }

    public void setName(String name){
        this.name = name;
    }

    // add new file in directory, Object "file" create inside object directory
    public void addFile(String name){
        File file = new File(name, this);
        files.add(file);
    }

    public String getName(){
        return name;
    }

    // return files in directory
    public ArrayList<File> getFiles(){
        return files;
    }

    // remove file from directory
    public void deleteFile(File file) {
        files.remove(file);
    }

    public boolean isNameCorrect(String name) {
        char [] charsName = name.toCharArray();
        boolean result = true;
        for (int i = 0; i < charsName.length; i++) {
            if (setIllegalChars.contains(charsName[i])) {
                result = false;
                break;
            }
        }
        return result;
    }

}
