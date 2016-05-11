package SoftServe.Task6;

public class ClassPointers {

    public static void main(String[] args) {
        A objF = new A(1, "First");
        A objS = new A(2, "Second");
        objS = objF;
        objF.setName("Third");
        System.out.println(objS.getName());
    }
}
