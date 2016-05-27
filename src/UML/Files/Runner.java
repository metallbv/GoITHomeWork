package UML.Files;

public class Runner {

    public static void main(String[] args) {

        try {
            // Create directories
            Directory directory1 = new Directory("C:\\tmp");
            System.out.println("Create directory " + directory1);

            Directory directory2 = new Directory("C:\\Temp");
            System.out.println("Create directory " + directory2);

            // Create files
            System.out.println("Create files");
            File file1 = new File("file", directory1);
            File file2 = new File("FILE", directory2);

            System.out.println(directory1);
            System.out.println(directory2);

            // try to delete files
            System.out.println("Delete files");
            directory1.deleteFile(file1);
            directory2.deleteFile(file2);

            System.out.println(directory1);
            System.out.println(directory2);


        } catch (IncorrectSymbol inEx) {
            System.out.println(inEx.getMessage());
        }


    }

}
