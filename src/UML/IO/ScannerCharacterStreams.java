package UML.IO;

import java.io.*;
import java.util.Scanner;

/**
 * Created by v.babiak on 03.06.2016.
 */
public class ScannerCharacterStreams {

    public static void main(String[] args) {

        try (Scanner reader = new Scanner(new BufferedReader(new FileReader("CharacterStreamsForReading")));
             BufferedWriter writer = new BufferedWriter(new FileWriter("CharacterStreamsForWriting"))) {

            while (reader.hasNext()) {
                writer.write(reader.next());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

