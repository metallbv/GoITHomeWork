package UML.IO;

import java.io.*;

/**
 * Created by v.babiak on 03.06.2016.
 */
public class ByteStreams {

    public static void main(String[] args) {

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("ByteStreamForReading"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("ByteStreamForWriting"))) {

            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
