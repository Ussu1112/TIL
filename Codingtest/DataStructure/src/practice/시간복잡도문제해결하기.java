package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시간복잡도문제해결하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        StringBuilder sb = new StringBuilder();
        String line = null;

        while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
            sb.append(line);
            if (sb.length() > 5)
                break;
        }

        int W = sb.charAt(0);
        int H = sb.charAt(1);
        int P = sb.charAt(2);
        int Q = sb.charAt(3);
        int T = sb.charAt(4);

        System.out.println("W = " + W);

        int currentX = (T + P) % (2 * W);
        int currentY = (T + Q) % (2 * H);
        if (currentX > W)
            currentX = 2 * W - currentX;
        else if (currentY > H) {
            currentY = 2 * H - currentY;
        }

        System.out.println(currentX + " " + currentY);
    }

}
