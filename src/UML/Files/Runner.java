package UML.Files;

public class Runner {

    public static void main(String[] args) {

        Directory directory1 = new Directory("C:\\*|||tmp");
        System.out.println("Create directory " + directory1.getName());
        Directory directory2 = new Directory("C:\\*|");
        System.out.println("Create directory " + directory2);
    }

}
