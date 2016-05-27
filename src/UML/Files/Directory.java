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

    public Directory(String name) throws IncorrectSymbol{

        ArrayList<Character> incorrectSymbols = CheckNameCorrect(name);
        if (incorrectSymbols.isEmpty()) {
        this.name = name;
        } else {
            throw new IncorrectSymbol(name, incorrectSymbols.toString());
        }

    }

    public void setName(String name){
        this.name = name;
    }

    // add new file in directory, Object "file" create inside object directory
    public void addFile(File file){
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
    public void deleteFile(File file) throws IllegalStateException{
        if (files.isEmpty() || !files.contains(file)) {
            throw new IllegalStateException("" + this + "hasn't contains file " + file);
        } else {
            files.remove(file);
        }
    }

    public ArrayList<Character> CheckNameCorrect(String name) {
        char [] charsName = name.toCharArray();
        ArrayList<Character> incorrectSymbols = new ArrayList<Character>();

        for (int i = 0; i < charsName.length; i++) {
            if (setIllegalChars.contains(charsName[i])) {
                incorrectSymbols.add(charsName[i]);
            }
        }
        return incorrectSymbols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Directory ");
        sb.append(this.getName());
        sb.append(" contains: ");
        sb.append(this.getFiles());
        return sb.toString();
    }

}
