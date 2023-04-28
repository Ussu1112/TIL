package practice.java8to11;

public class Foo {

    public static void main(String[] args) {
        RunSomething runSomething = () -> System.out.println("doIt!");

        runSomething.doIt();

        RunSomething runSomething1 = () -> System.out.println("Hey");

        runSomething1.doIt();
    }
}
