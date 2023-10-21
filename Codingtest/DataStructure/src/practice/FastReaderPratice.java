package practice;

import java.io.*;
import java.util.StringTokenizer;

public class FastReaderPratice {

    static String N;
    static String M;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextLine();
        M = scan.nextLine();
    }
    public static void main(String[] args) {
        input();
        solution();
    }

    private static void solution() {
        String[] time = N.split(":");
        int nowHH = Integer.parseInt(time[0]);
        int nowMM = Integer.parseInt(time[1]);
        int nowSS = Integer.parseInt(time[2]);
        int nowSecondAmount = nowHH * 3600 + nowMM * 60 + nowSS;

        int saltHH = Integer.parseInt(M.substring(0,2));
        int saltMM = Integer.parseInt(M.substring(3,5));
        int saltSS = Integer.parseInt(M.substring(6,8));
        int saltSecondAmount = saltHH * 3600 + saltMM * 60 + saltSS;

        int answerSecondAmount = saltSecondAmount - nowSecondAmount;
        if (answerSecondAmount <= 0)
            answerSecondAmount += 24 * 3600;

        int answerHour = answerSecondAmount / 3600;
        int answerMinute = (answerSecondAmount % 3600) / 60;
        int answerSecond = answerSecondAmount % 60;

        System.out.printf("%02d:%02d:%02d", answerHour, answerMinute, answerSecond);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
