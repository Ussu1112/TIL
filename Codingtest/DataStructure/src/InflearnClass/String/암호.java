package InflearnClass.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 암호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        System.out.println(solution(cnt, input));
    }

    private static String solution(int cnt, String input) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        input = input.replace("#", "1");
        input = input.replace("*", "0");

        for (int i = 1; i <= cnt; i++) {
            answer.add(input.substring(0, 7));
            input = input.substring(7);
        }

        for (String s : answer) {
            sb.append((char) Integer.parseInt(s, 2));
        }

        return sb.toString();
    }
}
