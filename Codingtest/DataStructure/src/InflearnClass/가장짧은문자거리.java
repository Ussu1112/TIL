package InflearnClass;

import java.util.Scanner;

public class 가장짧은문자거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char inputChar = sc.next().charAt(0);
        System.out.println(solution(input, inputChar));
    }

    private static String solution(String input, char inputChar) {
        char[] inputArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputArr.length; i++) {
            int count = 0;
            for (int j = i; j < inputArr.length; j++) {
                if (inputArr[j] == inputChar){
                    break;
                } else {
                    count++;
                }
            }
            sb.append(count);
        }

        return sb.toString();
    }

}
