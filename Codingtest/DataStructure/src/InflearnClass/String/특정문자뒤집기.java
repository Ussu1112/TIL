package InflearnClass.String;

import java.util.Scanner;

public class 특정문자뒤집기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] s = input.toCharArray();

        solution(s);
    }

    private static void solution(char[] inputArr) {
        StringBuilder answer = new StringBuilder();

        int lt = 0, rt = inputArr.length-1;
        while (lt < rt){
            if (!Character.isAlphabetic(inputArr[lt])) {
                answer.append(inputArr[lt]);
                lt++;
            } else if (!Character.isAlphabetic(inputArr[rt])) {
                rt--;
            } else {
                char tmp = inputArr[lt];
                inputArr[lt] = inputArr[rt];
                inputArr[rt] = tmp;
                answer.append(inputArr[lt]);
                lt++;
                rt--;
            }

        }

        for (int i = lt; i < inputArr.length; i++) {
            answer.append(inputArr[i]);
        }

        System.out.println(answer);
    }
}
