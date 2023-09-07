package InflearnClass;

import java.util.Scanner;

public class 보이는학생 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        int[] inputArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            inputArr[i] = sc.nextInt();
        }

        System.out.println(solution(inputArr));
    }

    private static int solution(int[] inputArr) {
        int count = 1;
        int studentHeight = inputArr[0];

        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i] > studentHeight){
                count++;
                studentHeight = inputArr[i];
            }
        }
        return count;
    }
}
