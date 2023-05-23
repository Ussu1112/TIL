package LiveClass.day04;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }

        Arrays.sort(arrN);

        int m = sc.nextInt();
        int[] arrM = new int[m];

        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
            System.out.println(binarySearch(arrN, arrM[i]));
        }


    }

    private static int binarySearch(int[] arrN, int i) {
        int left = 0;
        int right = arrN.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arrN[mid] == i) {
                return 1;
            }
            else if (arrN[mid] < i) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
