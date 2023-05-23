package LiveClass.day02;

import java.util.ArrayList;
import java.util.List;

public class Recursive_5 {
    public static void main(String[] args) {
        System.out.println(PascalTriangle(8));
    }

    private static List<Integer> PascalTriangle(int i) {
        List<Integer> row = new ArrayList<>();
        if ( i == 1 ){
            row.add(1);
            return row;
        } else {
            List<Integer> previousRow = PascalTriangle(i-1);
            row.add(1);
            for (int j = 0; j < previousRow.size()-1; j++) {
                row.add(previousRow.get(j) + previousRow.get(j+1));
            }
            row.add(1);
            System.out.println(previousRow);
        }
        return row;
    }
}
