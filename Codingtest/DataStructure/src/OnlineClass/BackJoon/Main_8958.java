package OnlineClass.BackJoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            foo(sc.next());
        }
    }

    private static void foo(String s) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        int sum = 0;

        while (i < s.length()){
            char c = s.charAt(i);

            if (c == 'O') {
                stack.push(c);
                sum += stack.size();
            } else {
                stack.clear();
            }
            i++;
        }
        System.out.println(sum);
    }
}
