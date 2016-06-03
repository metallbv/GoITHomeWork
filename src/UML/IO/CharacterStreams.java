package UML.IO;

import java.io.*;

/**
 * Created by v.babiak on 03.06.2016.
 */
public class CharacterStreams {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("CharacterStreamsForReading"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("CharacterStreamsForWriting"))) {

            int c;

            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

