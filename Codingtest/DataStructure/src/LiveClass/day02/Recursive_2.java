package LiveClass.day02;

public class Recursive_2 {
    public static void main(String[] args) {
        System.out.println(recursion(4));

        /*
        * 재귀의 이해
        * 스스로를 호출하는 함수
        * 가장 중요한 것은 언제 멈추어야 할 지를 나타내는 종료 조건
        *
        * 문제를 푸는 전체 과정을 펼쳐 생각했을 때
        * 문제 풀이 과정의 일부분이 문제를 푸는 과정과 유사하다.
        * */
    }

    private static int recursion(int i) {
        if (i <= 0 ){  // 종료조건
            return 0;
        }
        return i + recursion(i-1);
    }
}
