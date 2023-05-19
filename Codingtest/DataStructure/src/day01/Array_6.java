package day01;

import java.util.Arrays;

public class Array_6 {
    public static void main(String[] args) {
        int[] array1 = {3, 1, 4, 2, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {5, 2, 3, 4, 1};

        // sort() : 배열 정렬
        Arrays.sort(array1);
        System.out.println("sort() : " + Arrays.toString(array1));

        // binarySearch() : 배열에서 원소를 이진 검색
        int searchIndex = Arrays.binarySearch(array1, 3);
        System.out.println("binarySearch() : " + searchIndex);

        // equals() : 두 배열이 같은지 확인
        boolean isEqual = Arrays.equals(array1, array2);
        System.out.println("equals() : " + isEqual );




    }
}
