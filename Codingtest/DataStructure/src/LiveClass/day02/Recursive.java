package LiveClass.day02;

public class Recursive {
    public static void main(String[] args) {
        recursion(1);
    }

    private static void recursion(int i) {
        if ( i < 5 ){
            System.out.println(i);
            recursion(i+1);
        }
    }
}
