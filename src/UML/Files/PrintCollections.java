package UML.Files;

import UML.Cipher.CaesarCipher;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Home on 31.05.2016.
 */
public class PrintCollections {

    public void PrintAnyCollections(Set<Directory> collection) {

        // Создаем класс шифратора
        CaesarCipher cipher = new CaesarCipher();

        // у нас должны быть колонки одинакового размера, поэтому для каждого елемента коллекции получим
        // максимальный размер элемента
        ArrayList<Integer> columnsSize = new ArrayList<>();
        for (Directory directory : collection) {
            ArrayList<File> files = directory.getFiles();
            for (int i = 0; i < files.size(); i++) {
                int sizeFile = files.get(i).getName().length();
                if (columnsSize.size() < i + 1) {
                    columnsSize.add(sizeFile);
                } else if (columnsSize.get(i) < sizeFile){
                    columnsSize.set(i, sizeFile);
                }
            }
        }

        for (Directory directory : collection) {
            ArrayList<File> files = directory.getFiles();
            for (int i = 0; i < files.size(); i++) {
                String space = getSpace(files.get(i).getName(), columnsSize.get(i));
                System.out.print(cipher.encryption(files.get(i).getName() + space + "|", 1));
            }

            System.out.println();
        }

        /*collection
                .stream()
                .forEach(element -> System.out.println(element));*/

    }

    private String getSpace(String name, Integer size) {

        StringBuilder sb = new StringBuilder();
        int nameLength = name.length();
        while (nameLength < size){
            sb.append(" ");
            nameLength++;
        }
        return sb.toString();
    }

}
