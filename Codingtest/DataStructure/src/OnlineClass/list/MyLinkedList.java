package OnlineClass.list;

public class MyLinkedList<T> implements IList<T>{
    // 크기 값 선언
    private int size;
    // headNode 선언
    private Node head;

    public MyLinkedList(){
        this.size = 0;
        // dummy node head 노드에 더미 값을 두어 계산이나 로직에 용이하게 사용
        this.head = new Node(null);
    }

    @Override
    public void add(T t) {
        // LinkedList 에서 제일 끝에 넣는다
        Node curr = this.head;
        // 제일 끝에 도달하기 위한 while 문
        while (curr.next != null){
            curr = curr.next;
        } // 도달 시에
        Node node = new Node(t);
        // 새로운 노드를 넣는다.
        curr.next = node;
        // size 크기 증가
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (index > this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node prev = this.head;
        Node curr = prev.next;
        int i = 0;
        // 인덱스까지 한칸씩 이동하며 인덱스의 위치까지 도달한다.
        while ( i++ < index) {
            // curr 의 한단계 전 노드
            prev = prev.next;
            // list 의 가장 끝에 있는 노드
            curr = curr.next;
        }
        // 노드 생성
        Node node = new Node(t, curr);
        prev.next = node;
        this.size++;
        // 최종 위치 (prev -> index[t] -> curr
    }

    @Override
    public void clear() {
        // head.next 가 null 로 초기화 되면 데이터를 찾을 수가 없음
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        // 데이터 t와 동일한 데이터 지운다.
        Node prev = this.head;
        Node curr = prev.next;
        while (curr != null) {
            // 데이터 t와 동일한 데이터를 LinkedList 에서 찾는다.
            if (curr.data.equals(t)){ // 찾았다면
                // [1, t, 3] 이라고 하면 next 가 1->t 인 부분을 1 -> 3으로 변경해준다
                prev.next = curr.next;
                curr.next = null;
                this.size--;
                return true;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        // LinkedList 의 index 번째 값의 데이터를 지운다
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node prev = this.head;
        Node curr = prev.next;
        int i = 0;
        while (i++ < index){
            // 인덱스 위치까지 검색
            prev = prev.next;
            curr = curr.next;
        }
        // prev.next 를 curr.next 로 변경하고 기존 curr.next 의 값을 삭제한다.
        prev.next = curr.next;
        curr.next = null;
        this.size--;
        return false;
    }

    @Override
    public T get(int index) {
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        // 맨 처음 head 에는 더미값이 들어있으니 그 이후부터 실행
        Node curr = this.head.next;
        int i = 0;
        while (i++ < index){
            curr = curr.next;
        }
        return curr.data;


    }

    @Override
    public int indexOf(T t) {
        Node curr = this.head.next;
        int index = 0;
        while (curr != null){
            if(t.equals(curr.data)){
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node curr = this.head.next;
        while (curr != null){
            if(t.equals(curr.data)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        // LinkedList 노드기반이기 때문에 노드 생성
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
