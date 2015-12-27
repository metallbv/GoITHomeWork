package UML.Files;

public class File {
    private String name;
    private Directory directory; // Path to the file

    public File(String name, Directory directory){
        this.name = name;
        this.directory = directory;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDirectory(Directory directory){
        this.directory = directory;
    }

    public String getName(){
        return name;
    }

    public Directory getDirectory(){
        return directory;
    }

}
