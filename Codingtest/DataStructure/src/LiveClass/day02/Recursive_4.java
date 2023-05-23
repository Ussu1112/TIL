package LiveClass.day02;

public class Recursive_4 {
    public static void main(String[] args) {
        System.out.println(fibonacci(12));


    }

    private static int fibonacci(int i) {
        if (i==1){
            return 0;
        } else if (i==2){
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci( i - 2);
        }
    }
}
