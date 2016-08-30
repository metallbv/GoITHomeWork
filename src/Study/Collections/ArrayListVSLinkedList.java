package Study.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class ArrayListVSLinkedList {

    private static long start, finish;
    private static double result;

    public static void main(String[] args) {

        TimeUnit seconds = null;

        // Add 1 000 000 elements to the list
        start = System.nanoTime();
        addElementsToTheLinkedList();
        finish = System.nanoTime();
        result = (finish - start) / 1000000000.0;
        System.out.println("Adding 1000000 elements to the LinkedList takes " + result);
        start = System.nanoTime();
        addElementsToTheArrayList();
        finish = System.nanoTime();
        result = (finish - start) / 1000000000.0;
        System.out.println("Adding 1000000 elements to the ArrayList takes " + result);

    }

    public static void addElementsToTheLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 1000000; i++){
            list.addLast(i);
        }
    }

    public static void addElementsToTheArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1000000; i++){
            list.add(0, i);
        }
    }

}
