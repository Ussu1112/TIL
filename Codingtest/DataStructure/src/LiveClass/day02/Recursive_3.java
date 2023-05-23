package LiveClass.day02;

public class Recursive_3 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            // 중복 연산이 너무 많아 실상으로는 사용하진 않는다.
            return n * factorial(n - 1);
        }
    }

}
