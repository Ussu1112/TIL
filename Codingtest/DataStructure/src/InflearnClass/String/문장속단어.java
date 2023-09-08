package InflearnClass.String;

import java.util.Scanner;

public class 문장속단어 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String answer = "";

        StringBuilder temp = new StringBuilder();
        for (char x : input.toCharArray()) {
            if (x == ' '){
                if( temp.length() > answer.length()) {
                    answer = String.valueOf(temp);
                }
                temp.setLength(0);
            }
            else {
                temp.append(x);
            }
        }

        if( temp.length() > answer.length()) {
            answer = String.valueOf(temp);
        }

        return answer;
    }
}
