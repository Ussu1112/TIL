package InflearnClass;

/*
* 설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.

입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.

예시 입력 1

gooG
예시 출력 1

YES*/

import java.util.*;
public class 회문문자열 {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();
        String inputToLower = input.toLowerCase();

        if (input.length() % 2 == 1) {
            StringBuilder str = new StringBuilder(inputToLower);
            str.deleteCharAt(str.length() / 2);
            inputToLower = String.valueOf(str);
        }

        for (int i = 0; i < inputToLower.length() / 2; i++)
            stack.push(inputToLower.charAt(i));

        for (int i = input.length() / 2; i < inputToLower.length(); i++) {
            if (stack.peek() == inputToLower.charAt(i)) {
                stack.pop();
            } else {
                return NO;
            }
        }
        return YES;
    }

    private static String solution2(String input){
        String sb = new StringBuilder(input).reverse().toString();
        if(input.equalsIgnoreCase(sb))
            return YES;
        else
            return NO;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
        System.out.println(solution2(input));
    }
}
