package UML.Files;

import UML.Cipher.CaesarCipher;

import java.io.*;

/**
 * Created by v.babiak on 03.06.2016.
 */
public class ReadWriteFile {

    public static void main(String[] args) {

        CaesarCipher caesarCipher = new CaesarCipher();
        StringBuilder resultOfEncription = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("CharacterStreamsForReading")); // CharacterStreamsForReading
             BufferedWriter writer = new BufferedWriter(new FileWriter("CharacterStreamsForWriting"));) {

            String currentLine, decryptionLine, encryptionLine;

            while ((currentLine = reader.readLine()) != null) {
                decryptionLine = caesarCipher.decryption(currentLine, 0);
                resultOfEncription.append(caesarCipher.encryption(decryptionLine, 1) + '\n');
            }

            writer.write(resultOfEncription.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
