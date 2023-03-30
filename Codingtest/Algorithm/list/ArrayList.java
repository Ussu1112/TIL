package list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T>{

    // 코드의 유지보수 관점에서 따로 선언하는것이 좋다.
    private static final int DEFAULT_SIZE = 50;

    private T[] elements;
    private int size;

    public MyArrayList() {
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T t) {
        //배열의 크기가 초과되는 경우
        if( this.size == this.elements.length) {
            // Arrays.copyOf를 사용하여 기존 배열을 카피하고 전체 size는 2배를 해준다.
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        // 배열에 값을 추가 가장 맨 뒤에 추가하기 때문에 배열의 size 값에 추가하고 size 값을 늘린다.
        this.elements[this.size++] = t;
    }

    @Override
    public void insert(int index, T t) {
        // 정해진 index 에 값을 넣기 때문에 넣는 자리가 중간이라면 index 부터 끝까지의 배열을 한칸 뒤로 미룬다
        for (int i = index; i< this.size; i++){
            this.elements[i + 1] = this.elements[i];
        }
        // index 에 값넣기
        this.elements[index] = t;
        // size 값 증가
        this.size++;
    }

    @Override
    public void clear() {
        // 배열의 값을 비워둔다.
        // 생성자가 하는 역할과 동일하다.
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean delete(T t) {
        // 삭제하고 싶은 데이터를 찾아서 삭제
        for (int i = 0; i < this.size; i++){
            // 전체 조회하여 t 값과 동일한 값을 배열에서 찾는다.
            if(this.elements[i].equals(t)){
                // 원하는 값을 찾은 뒤에는 deleteByIndex 와 로직이 동일하다. 삭제 뒤에는 true 를 반환한다.
                for (int j = 1; j < this.size - 1; j++ ){
                    this.elements[j] = this.elements[j+1];
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        // 삭제하고 싶은 위치를 찾아 삭제
        // index 를 검증
        if (index < 0 || index > this.size -1){
            return false;
        }
        // add 와 반대로 해당 index 가 삭제되면 한칸 뒤에 있는 정보를 땡겨온다.
        for (int i = index; i < this.size - 1; i++){
            this.elements[i] = this.elements[i + 1];
        }
        // 요소가 삭제되어 크기를 줄인다.
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        // 배열의 index 위치에 있는 값을 반환
        // index 를 검증
        if (index < 0 || index > this.size -1){
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public int indexOf(T t) {
        // 입력 받은 t의 값을 배열 내에 찾아보고 index 의 위치를 반환
        for (int i = 0; i < this.size; i++){
            if (this.elements[i].equals(t)){
                return 1;
            }
        }
        // return 시 0으로 할경우 this.elements[0]에도 값이 있기 때문에 접근할 수 없는 음수의 값으로 지정한다.
        return -1;
    }

    @Override
    public boolean isEmpty() {
        // 배열의 내부에 값이 비어있는지 확인
        // 배열의 크기가 0 인가? 를 확인하여 반환
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        // 입력 받은 t의 값을 배열 내에 찾아보고 bool 값으로 반환
        for (int i = 0; i < this.size; i++){
            if(this.elements[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        // 배열의 크기를 반환
        return this.size;
    }
}
