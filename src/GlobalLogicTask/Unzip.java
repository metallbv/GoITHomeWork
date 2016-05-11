package GlobalLogicTask;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzip {

    private static final String filePath = "D:\\Java\\GlobalLogic\\test case.zip";
    private static Comparator comp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    };
    private static TreeMap<String, String> prodactMap = new TreeMap<>(comp);

    public static void main(String[] args) {

        String testResourcesDir = "/../../GlobalLogicTask/";
        Path path = Paths.get(testResourcesDir);

        File fileZip = new File(filePath);

        if (!fileZip.exists() || !fileZip.canRead()) {
            System.out.println("File cannot be read");
            return;
        }

        try {
            ZipFile zip = new ZipFile(filePath);
            Enumeration entries = zip.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();

                if (entry.isDirectory()) {
                    new File(fileZip.getParent(), entry.getName()).mkdirs();
                } else {
                    write(zip.getInputStream(entry),
                            new BufferedOutputStream(new FileOutputStream(
                                    new File(fileZip.getParent(), entry.getName()))));
                }

                File unzipFile = new File(fileZip.getParent(), entry.getName());
                readFile(unzipFile, prodactMap);
            }

            zip.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        printMap(prodactMap);
    }

    // Read file
    private static void readFile(File unzipFile, TreeMap prodactMap) throws FileNotFoundException {

        try {
            BufferedReader in = new BufferedReader(new FileReader(unzipFile.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    prodactMap.put(s, unzipFile.getName());
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Create unzip file
    private static void write(InputStream in, OutputStream out) throws IOException {
        byte [] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
    }

    // Print map
    private static void printMap(TreeMap<String, String> prodactMap) {

        char capitalFirstLetter = ' ';
        for (Map.Entry<String, String> values : prodactMap.entrySet()) {
            char productFirstLetter = Character.toUpperCase(values.getKey().charAt(0));
            if (capitalFirstLetter != productFirstLetter) {
                capitalFirstLetter = productFirstLetter;
                System.out.println(capitalFirstLetter + " : " + values.getKey());
            } else {
                System.out.println("    " + values.getKey());
                //System.out.println("'" + values.getKey() + "'" + "->" + "'" + values.getValue() + "'");
            }
        }
    }

}
