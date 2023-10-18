import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(solution(input1, input2));
    }

    private static int solution(String input1, String input2) {
        int answer = 0;
        int[] countA = getAlphabetCount(input1);
        int[] countB = getAlphabetCount(input2);

        for (int i = 0; i < countA.length; i++) {
            answer += Math.abs(countA[i]-countB[i]);
        }

        System.out.println(Arrays.toString(countA));
        System.out.println(Arrays.toString(countB));

        return answer;
    }

    private static int[] getAlphabetCount(String input1) {
        int[] count = new int[26];
        for (int i = 0; i < input1.length(); i++) {
            count[input1.charAt(i) - 'a']++;
        }
        return count;
    }
}
