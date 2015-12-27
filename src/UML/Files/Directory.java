package UML.Files;

import java.util.ArrayList;

public class Directory {

    private String name; // Path to directory
    private ArrayList<File> files = new ArrayList<File>(); // List of files in directory

    public Directory(String name){
        this.name = name;
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
}
