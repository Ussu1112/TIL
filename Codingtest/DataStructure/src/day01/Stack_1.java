package day01;

import java.util.Stack;

public class Stack_1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int removedElement = stack.pop();
        System.out.println(removedElement);;

        int topElement = stack.peek();
        System.out.println(topElement);

        boolean isStackEmpty = stack.empty();
        System.out.println(isStackEmpty);

        int position = stack.search(2);
        System.out.println(position);
    }
}
