package practice;

import java.util.Scanner;

public class Main {

    static boolean[] isEurekaNumber = new boolean[1001];
    public static void main(String[] args) {
        process();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[44];
        for (int i = 1; i <  T.length; i++) {
            T[i] = i * (i - 1)/2;
        }

        System.out.println());;

    }

    private static boolean process() {

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                for (int k = 0; k < T.length; k++) {
                    int sum = T[i] + T[j] + T[k];
                    if (req == sum)
                        return true;
                }
            }
        }
        return false;
    }
}
