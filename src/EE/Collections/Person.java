package EE.Collections;

import java.util.Random;

public class Person implements Comparable{

    private static int counter = 0;
    private final String name, surname;
    private int age, id;
    final Random random = new Random();

    public Person(){
        counter++;
        this.id = counter;
        this.name = "Name";
        this.surname = "Surname";
        this.age = random.nextInt(100);
    }

    public static int getCounter() {
        return counter;
    }

    public Person(String name, String surname, int age) {
        counter++;
        this.id = counter;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {return id;}

    @Override
    public int compareTo(Object o) {
        return getName().compareTo(((Person)o).getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (id != person.id) return false;
        if (!name.equals(person.name)) return false;
        return surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + id;
        return result;
    }
}
