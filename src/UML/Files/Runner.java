package UML.Files;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Runner {

    public static void main(String[] args) {

        Set<Directory> directorySet = new TreeSet<Directory>(new Comparator<Directory>() {
            @Override
            public int compare(Directory o1, Directory o2) {
                int sizeo1 = o1.getFiles().size();
                int sizeo2 = o2.getFiles().size();
                if (sizeo1 < sizeo2) {
                    return -1;
                } else if (sizeo1 == sizeo2) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return 1;
                }
            }
        });

        try {
            // Create directories
            Directory directory1 = new Directory("C:\\tmp");
            File file1 = new File("One", directory1);
            File file2 = new File("Two", directory1);
            File file3 = new File("Three", directory1);
            File file0 = new File("Zero", directory1);
            directorySet.add(directory1);
            //System.out.println("Create directory " + directory1);

            Directory directory2 = new Directory("C:\\Temp");
            File file4 = new File("Four", directory2);
            File file5 = new File("Five", directory2);
            File file6 = new File("Second", directory2);
            directorySet.add(directory2);
            //System.out.println("Create directory " + directory2);

            Directory directory3 = new Directory("C:\\Users");
            File file7 = new File("Seven", directory3);
            File file8 = new File("Eight", directory3);
            File file9 = new File("Nine", directory3);
            directorySet.add(directory3);
            // Create files
            //System.out.println("Create files");

            PrintCollections printCollections = new PrintCollections();
            printCollections.PrintAnyCollections(directorySet);

            //System.out.println(directory1);
            //System.out.println(directory2);

            // try to delete files
            //System.out.println("Delete files");
            //directory1.deleteFile(file1);
            //directory2.deleteFile(file2);

            //System.out.println(directory1);
            //System.out.println(directory2);


        } catch (IncorrectSymbol inEx) {
            System.out.println(inEx.getMessage());
        }


    }

}
