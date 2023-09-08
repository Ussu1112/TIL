package InflearnClass.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 중복문자제거 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        solution(input);
    }

    private static void solution(String input) {
        List<Character> characterList = new ArrayList<>();
        char[] chars = input.toCharArray();

        for (char x : chars) {
            if (!characterList.contains(x)) {
                characterList.add(x);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (Character s : characterList) {
            answer.append(s);
        }

        System.out.println(answer);
    }
}
