package LiveClass.day05.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PM_42577 {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (int i = 0; i < set.size(); i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
//                if(set.contains(phone_book))


                
            }
        }



        return answer;
    }
}
