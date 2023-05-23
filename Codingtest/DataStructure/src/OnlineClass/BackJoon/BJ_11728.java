package OnlineClass.BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
* */

public class BJ_11728 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //배열 A size
        int M = scanner.nextInt(); //배열 B size

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++){
            int n = scanner.nextInt();
            A.add(n);
        }

        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < M; i++){
            int m = scanner.nextInt();
            B.add(m);
        }

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while ( i < N && j< M) {
            int a = A.get(i);
            int b = B.get(j);
            if ( a <= b){
                result.add(a);
                i++;
            } else {
                result.add(b);
                j++;
            }
        }

        for (; i< N; i++){
            result.add(A.get(i));
        }

        for (; j < M; j++){
            result.add(B.get(j));
        }

        StringBuilder sb = new StringBuilder();
        for (int e : result){
            sb.append(e + " ");
        }
        System.out.println(sb.toString());

    }
}
