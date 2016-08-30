package Study.Stream;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Person p) {
        int result = this.getName().compareTo(p.getName());
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

}
