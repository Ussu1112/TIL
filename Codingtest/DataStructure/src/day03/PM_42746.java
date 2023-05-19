package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PM_42746 {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(Solution(numbers));
    }

    public static String Solution(int[] numbers){
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")){
            return "0";
        }

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        return answer.toString();
    }
}
