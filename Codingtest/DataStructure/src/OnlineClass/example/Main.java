package OnlineClass.example;


import java.io.*;
import java.util.*;

public class Main {

    private static final int capacity = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> attendance = new ArrayList<>(capacity);

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()){
            attendance.add(Integer.parseInt(input));
        }
        attendance.sort(Comparator.naturalOrder());

        for (int i = 1; i <= capacity; i++) {
            if (!attendance.contains(i))
                System.out.println(i);
        }
    }
}
