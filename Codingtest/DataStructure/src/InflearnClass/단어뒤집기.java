package InflearnClass;

import java.util.Scanner;

public class 단어뒤집기 {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            solution(input);
        }
    }
    private static void solution(String input) {
        sb.append(input);
        System.out.println(sb.reverse());
        sb.setLength(0);
    }
}
