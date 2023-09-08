package InflearnClass.String;

import java.util.Scanner;

public class 가장짧은문자거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char inputChar = sc.next().charAt(0);
        for (int x: solution(input, inputChar)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(String input, char inputChar) {
        char[] inputArr = input.toCharArray();
        int[] answer = new int[input.length()];
        int count = 1000;

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == inputChar){
                count = 0;
            } else {
                count++;
            }
            answer[i] = count;
        }

        count = 1000;

        for (int i = inputArr.length-1; i >= 0; i--) {
            if (inputArr[i] == inputChar){
                count = 0;
            } else {
                count++;
                answer[i] = Math.min(answer[i], count);
            }
        }
        return answer;
    }
}
