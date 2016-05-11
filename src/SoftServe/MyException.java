package SoftServe;

class MyException extends Exception{}
class MyRuntimeException extends RuntimeException{}
class A {
    //void method1() {throw new MyException(); }
    //void method2() (throw new MyRuntimeException(); )
    void method1() throws MyException {throw new MyException(); }
    //void method2() throws Exception (throw new Exception(); )
}
