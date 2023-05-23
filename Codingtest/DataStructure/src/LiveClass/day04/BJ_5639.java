package LiveClass.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5639 {
    // 트리를 코드로 구현하는 문제
    // 순회
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while ((input = br.readLine()) != null){
            root.insert(Integer.parseInt(input));
        }

        preOrder(root);

    }

    static void preOrder(Node node) {
        if (node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.num);
    }

    static class Node {
        int num;

        Node left, right;

        Node(int num) {
            this.num = num;
        }

        void insert(int num){
            if (num < this.num) {
                if (this.left == null){
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null){
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }
}
