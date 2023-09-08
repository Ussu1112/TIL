package InflearnClass.String;

import java.util.Scanner;

public class 대소문자변환 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        //A=65, Z=90, a=97, z=122
        System.out.println(solution(input1));
    }

    private static String solution(String input1) {
        StringBuilder sb = new StringBuilder();
        for (char x : input1.toCharArray()) {
            if ((int) x >= 65 && (int) x <= 90)
                sb.append(Character.toLowerCase(x));
            else
                sb.append(Character.toUpperCase(x));
        }
        return sb.toString();
    }
}
