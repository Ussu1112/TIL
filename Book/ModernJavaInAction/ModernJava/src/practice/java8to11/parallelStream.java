package practice.java8to11;

import java.util.Arrays;

public class parallelStream {

    public static void main(String[] args) {
        Arrays.asList("a", "b", "c", "d", "e")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

    }

}
