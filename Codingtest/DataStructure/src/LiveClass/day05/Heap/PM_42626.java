package LiveClass.day05.Heap;

import java.util.PriorityQueue;

public class PM_42626 {
    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> prQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            prQueue.add(scoville[i]);
        }
        System.out.println(prQueue);

        while (prQueue.peek() < K){
            if (prQueue.size() == 1)
                return -1;
            prQueue.add(prQueue.poll() + prQueue.poll() * 2);
            answer++;
        }

        return answer;
    }

}
