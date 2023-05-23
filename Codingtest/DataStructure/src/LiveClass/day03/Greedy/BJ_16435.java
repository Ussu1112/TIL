package LiveClass.day03.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_16435 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] H = new int[N];

        for (int i = 0; i < H.length; i++) {
            H[i] = sc.nextInt();
        }

        Arrays.sort(H);

        for (int i = 0; i < H.length; i++) {
            if (L >= H[i]){
                L++;
            } else {
                break;
            }
        }
        System.out.println(L);
    }
}
