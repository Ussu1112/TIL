package LiveClass.day03.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int timeTable[][] = new int[N][2];

        int answer = 0;

        for (int i = 0; i < N; i++) {
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.deepToString(timeTable));

        Arrays.sort(timeTable, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        System.out.println(Arrays.deepToString(timeTable));





        System.out.println(Arrays.deepToString(timeTable));


    }
}
