package day01;

import java.util.ArrayList;
import java.util.List;

public class List_2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // increase the capacity of the ArrayList
        list.ensureCapacity(20);

        // trim the capacity of the ArrayList
        list.trimToSize();

        // change the element at index 2
        list.set(2, "BlueCherry");

        List<String> subList = list.subList(1, 3);
        System.out.println("SubList : " + subList);

        int size = list.size();
        System.out.println("Size: " + size);

        String[] array = list.toArray(new String[list.size()]);
        for (String str : array){
            System.out.println(str);
        }

        int index = list.indexOf("Cherry");
        System.out.println("Index of Cherry: " + index);

        ArrayList<String> newList = new ArrayList<>();




    }
}
