package day01;

import java.util.LinkedList;

public class List_3 {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("item1");
        myList.add("item2");
        myList.add("item3");
        myList.add("item4");
        myList.add("item5");

        myList.addFirst("newItem1");
        System.out.println("After addFirst: " + myList);

        myList.addLast("newItem2");
        System.out.println("After addLast" + myList);




    }
}
