package EE.Collections;

import java.util.*;

public class TestCollections {

    private static long st, en;
    private static float[][] result;
    final static Random random = new Random();

    public static void main(String[] args) {

        int[] quantityOfElements = {10, 100, 1000};
        String[] collectionsName = {"ArrayList", "LinkedList", "HashSet", "TreeSet"};
        result = new float[4][7];

        System.out.println("                   add       get    remove  contains  populate  iter add  iter Remove");

        // Create different type of collections
        for (int i = 1; i <= quantityOfElements.length; i++) {
            ArrayList<Person> personArrayList = new ArrayList<Person>();
            LinkedList<Person> personLinkedList = new LinkedList<Person>();
            HashSet<Person> personHashSet = new HashSet<Person>();
            TreeSet<Person> personTreeSet = new TreeSet<Person>();

            // Fill the collections (populate)
            result[0][4] = fillArrayList(personArrayList, quantityOfElements[i - 1]);
            result[1][4] = fillLinkedList(personLinkedList, quantityOfElements[i - 1]);
            result[2][4] = fillHashSet(personHashSet, quantityOfElements[i - 1]);
            result[3][4] = fillTreeSet(personTreeSet, quantityOfElements[i - 1]);

            // Add 1000 elements
            result[0][0] = addElementsToArrayList(personArrayList, quantityOfElements[i - 1]);
            result[1][0] = addElementsToLinkedList(personLinkedList, quantityOfElements[i - 1]);
            result[2][0] = addElementsToHashSet(personHashSet, quantityOfElements[i - 1]);
            result[3][0] = addElementsToTreeSet(personTreeSet, quantityOfElements[i - 1]);

            // Get elements
            result[0][1] = getElementsFromArrayList(personArrayList, quantityOfElements[i - 1]);
            result[1][1] = getElementsFromLinkedList(personLinkedList, quantityOfElements[i - 1]);

            // Remove elements
            result[0][2] = removeElementsFromArrayList(personArrayList, quantityOfElements[i - 1]);
            result[1][2] = removeElementsFromLinkedList(personLinkedList, quantityOfElements[i - 1]);
            result[2][2] = removeElementsFromHashSet(personHashSet);
            result[3][2] = removeElementsFromTreeSet(personTreeSet);

            // Contains
            result[0][3] = containElementsArrayList(personArrayList);
            result[1][3] = containElementsLinkedList(personLinkedList);
            result[2][3] = containElementsHashSet(personHashSet);
            result[3][3] = containElementsTreeSet(personTreeSet);

            // Iterator add
            result[0][5] = addIteratorArrayList(personArrayList);
            result[1][5] = addIteratorLinkedList(personLinkedList);

            // Iterator remove
            result[0][6] = removeIteratorArrayList(personArrayList);
            result[1][6] = removeIteratorLinkedList(personLinkedList);
            result[2][6] = removeIteratorHashSet(personHashSet);
            result[3][6] = removeIteratorTreeSet(personTreeSet);

            // Print the result
            for (int x = 0; x < result.length; x++) {
                System.out.printf("%12s", collectionsName[x] + ": ");
                for (int j = 0; j < result[x].length; j++) {
                    System.out.printf("%10.2f", result[x][j]);
                }
                System.out.println();
            }
            System.out.println();

        }

    }

    private static float removeIteratorTreeSet(TreeSet<Person> personTreeSet) {
        Iterator setIterator = personTreeSet.iterator();
        st = System.nanoTime();
        int i = 0;
        while (setIterator.hasNext()){
            setIterator.next();
            setIterator.remove();
            i++;
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (en - st) / 1000000;
    }

    private static float removeIteratorHashSet(HashSet<Person> personHashSet) {
        Iterator setIterator = personHashSet.iterator();
        st = System.nanoTime();
        int i = 0;
        while (setIterator.hasNext()){
            setIterator.next();
            setIterator.remove();
            i++;
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (en - st) / 1000000;
    }

    private static float removeIteratorLinkedList(LinkedList<Person> personLinkedList) {
        ListIterator listIterator = personLinkedList.listIterator();
        st = System.nanoTime();
        int i = 0;
        while (listIterator.hasNext()){
            listIterator.next();
            listIterator.remove();
            i++;
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (en - st) / 1000000;
    }

    private static float removeIteratorArrayList(ArrayList<Person> personArrayList) {
        ListIterator listIterator = personArrayList.listIterator();
        st = System.nanoTime();
        int i = 0;
        while (listIterator.hasNext()){
            listIterator.next();
            listIterator.remove();
            i++;
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (en - st) / 1000000;
    }

    private static float addIteratorLinkedList(LinkedList<Person> personLinkedList) {
        ListIterator listIterator = personLinkedList.listIterator();
        st = System.nanoTime();
        int i = 0;
        while (listIterator.hasNext()){
            listIterator.add(new Person());
            i++;
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (en - st) / 1000000;
    }

    private static float addIteratorArrayList(ArrayList<Person> personArrayList) {
        ListIterator listIterator = personArrayList.listIterator();
        st = System.nanoTime();
        int i = 0;
        while (listIterator.hasNext()){
            listIterator.add(new Person());
            i++;
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (en - st) / 1000000;
    }

    private static float containElementsTreeSet(TreeSet<Person> personTreeSet) {
        int i = 0;
        st = System.nanoTime();
        for (Person p : personTreeSet) {
            personTreeSet.contains(p);
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float containElementsHashSet(HashSet<Person> personHashSet) {
        int i = 0;
        st = System.nanoTime();
        for (Person p : personHashSet) {
            personHashSet.contains(p);
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float containElementsLinkedList(LinkedList<Person> personLinkedList) {
        int i = 0;
        st = System.nanoTime();
        for (Person p : personLinkedList) {
            personLinkedList.contains(p);
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float containElementsArrayList(ArrayList<Person> personArrayList) {
        int i = 0;
        st = System.nanoTime();
        for (Person p : personArrayList) {
            personArrayList.contains(p);
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float removeElementsFromTreeSet(TreeSet<Person> personTreeSet) {
        int i = 0;
        st = System.nanoTime();
        for (Person p : personTreeSet) {
            personTreeSet.remove(p);
            if (i >= 1000) break;
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float removeElementsFromHashSet(HashSet<Person> personHashSet) {
        Person[] arrayPersons = personHashSet.toArray(new Person[personHashSet.size()]);
        st = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            personHashSet.remove(arrayPersons[i]);
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float removeElementsFromLinkedList(LinkedList<Person> personLinkedList, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            personLinkedList.remove(random.nextInt(personLinkedList.size() - 1));
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float removeElementsFromArrayList(ArrayList<Person> personArrayList, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            personArrayList.remove(random.nextInt(personArrayList.size() - 1));
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float getElementsFromLinkedList(LinkedList<Person> personLinkedList, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            Person thisPerson = personLinkedList.get(random.nextInt(personLinkedList.size() - 1));
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float getElementsFromArrayList(ArrayList<Person> personArrayList, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            Person thisPerson = personArrayList.get(random.nextInt(personArrayList.size() - 1));
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float addElementsToTreeSet(TreeSet<Person> personTreeSet, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            personTreeSet.add(new Person());
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float addElementsToHashSet(HashSet<Person> personHashSet, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            personHashSet.add(new Person());
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float addElementsToLinkedList(LinkedList<Person> personLinkedList, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            personLinkedList.add(random.nextInt(quantityOfElement + 1000), new Person());
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float addElementsToArrayList(ArrayList<Person> personArrayList, int quantityOfElement) {
        st = System.nanoTime();
        for (int add = 0; add < 1000; add++) {
            personArrayList.add(random.nextInt(quantityOfElement + 1000), new Person());
        }
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float fillTreeSet(TreeSet<Person> personTreeSet, int size) {
        st = System.nanoTime();
        for (int i = 0; i < size * 1000; i++) personTreeSet.add(new Person());
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float fillHashSet(HashSet<Person> personHashSet, int size) {
        st = System.nanoTime();
        for (int i = 0; i < size * 1000; i++) personHashSet.add(new Person());
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float fillLinkedList(LinkedList<Person> personLinkedList, int size) {
        st = System.nanoTime();
        for (int i = 0; i < size * 1000; i++) personLinkedList.add(new Person());
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

    private static float fillArrayList(ArrayList<Person> personArrayList, int size) {
        st = System.nanoTime();
        for (int i = 0; i < size * 1000; i++) personArrayList.add(new Person());
        en = System.nanoTime();
        return (float) (en - st) / 1000000;
    }

}
