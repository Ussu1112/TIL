package InflearnClass;

import java.util.Scanner;

public class 문자열압축 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        char[] arr = (input + " ").toCharArray();
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (arr[i] == arr[i+1]){
                count++;
            } else {
                sb.append(arr[i]);
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
            }
        }
        return sb.toString();
    }
}
