package InflearnClass;

import java.util.Scanner;

public class 가위바위보 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        int[] inputA = new int[cnt];
        int[] inputB = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            inputA[i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            inputB[i] = sc.nextInt();
        }
        solution(inputA, inputB);
    }

    private static void solution(int[] inputA, int[] inputB) {
        //가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

        for (int i = 0; i < inputA.length; i++) {
            if (inputA[i] == inputB[i]){
                System.out.println("D");
            } else if ((inputB[i] == 1 && inputA[i] == 2)
                    || (inputB[i] == 2 && inputA[i] == 3)
                    || (inputB[i] == 3 && inputA[i] == 1))
                System.out.println("A");
            else if ((inputA[i] == 1 && inputB[i] == 2)
                    || (inputA[i] == 2 && inputB[i] == 3)
                    || (inputA[i] == 3 && inputB[i] == 1))
                System.out.println("B");
        }
    }
}
