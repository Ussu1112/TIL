package OnlineClass.sort.BubbleSort;

import OnlineClass.sort.ISort;

public class BubbleSort implements ISort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //전체 리스트
            for (int j = 0; j < arr.length - 1 - i; j++) { // 정렬된 리스트를 제외
                if (arr[j] > arr[j + 1]){
                    // 인덱스 1번의 위치에 있는 값이 2번의 위치에 있는 값보다 큰 경우 자리를 바꾼다.
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
