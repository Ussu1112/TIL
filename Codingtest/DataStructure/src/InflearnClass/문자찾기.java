package InflearnClass;

import java.util.Scanner;

public class 문자찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();
        System.out.println(solution(input1, input2.charAt(0)));
        System.out.println(solution2(input1, input2.charAt(0)));

    }

    private static int solution(String input1, char input2) {
        input1 = input1.toLowerCase();
        input2 = Character.toLowerCase(input2);
        int answer = 0;

        for (int i = 0; i < input1.length(); i++) {
            if(input1.charAt(i) == input2)
                answer++;
        }
        return answer;
    }

    private static int solution2(String input1, char input2){
        input1 = input1.toLowerCase();
        input2 = Character.toLowerCase(input2);
        int answer = 0;

        for (char x : input1.toCharArray()) {
            if (input2 == x){
                answer++;
            }
        }
        return answer;
    }
}
