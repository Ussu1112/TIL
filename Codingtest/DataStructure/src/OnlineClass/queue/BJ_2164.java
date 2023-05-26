package OnlineClass.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cardNum = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= cardNum; i++) {
            queue.offer(i);
        }

        int temp = 0;
        while (queue.size() > 1){
            queue.poll();
            temp = queue.poll();
            queue.offer(temp);
        }

        System.out.println(queue.poll());
    }
}
