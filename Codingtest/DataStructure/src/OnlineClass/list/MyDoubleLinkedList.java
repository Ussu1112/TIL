package OnlineClass.list;

public class MyDoubleLinkedList<T> implements IList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public void add(T t) {
        // 제일 끝 노드의 앞 노드
        Node last = this.tail.prev;
        // 현재 넣으려는 노드 선언 맨 마지막과 맨 마지막의 앞 노드까지 같이 선언
        Node node = new Node(t, last, this.tail);
        // last.next <=> node <=> tail.prev
        last.next = node;
        this.tail.prev = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = null;
        Node curr = null;

        int i = 0;
        if (index < this.size / 2){ // index 의 위치가 head 근처
            // 맨앞과 그다음 변수 선언
            prev = this.head;
            curr = this.head.next;

            // 인덱스 위치까지 검색
            while (i++ < index){
                prev = prev.next;
                curr = curr.next;
            }
        } else { // index 의 위치가 tail 근처
            // 맨끝과 그앞의 변수 선언
            curr = this.tail;
            prev = this.tail.prev;
            while (i++ < (this.size - index)){
                // 인덱스 위치까지 검색
                curr = curr.prev;
                prev = prev.prev;
            }
        }
        // 도달 시에 t, 인덱스의 앞과 뒤 노드로 변수 생성
        Node node = new Node(t, prev, curr);
        curr.prev = node;
        prev.next = node;
        this.size++;

    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node curr = prev.next;

        while (curr != null) {
            if (curr.data.equals(t)) {
                prev.next = curr.next;
                curr.next.prev = prev;
                curr.next = null;
                curr.prev = null;
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
        Node prev = null;
        Node curr = null;
        Node next = null;

        int i = 0;
        if (index < this.size / 2) { //index 가 head 쪽에 가까울 때
            prev = this.head;
            curr = this.head.next;
            // index 까지 검색
            while (i++ < index){
                prev = prev.next;
                curr = curr.next;
            }
            // curr 이 지우려는 index 에 도달했을 때 curr 기준 앞과 뒤를 연결한다.
            prev.next = curr.next;
            curr.next.prev = prev;
            // 앞과 뒤를 잘라 연결점이 없게한다. 수거는 GC가
            curr.next = null;
            curr.prev = null;
            size--;
        } else {
            curr = this.tail.prev;
            next = this.tail;
            while (i++ < this.size - index - 1){ // 데이터가 있는 곳부터 시작하기 때문에 -1을 추가로 해준다.
                next = next.prev;
                curr = curr.prev;
            }
            // a(curr.prev) <=> curr(삭제 대상) <=> next
            next.prev = curr.prev;
            curr.prev.next = next;
            curr.next = null;
            // 앞과 뒤를 잘라 연결점이 없게한다.
            curr.prev = null;
            size--;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node curr = null;
        if (index < this.size / 2){ // index 가 head 쪽에 가까울 때
            curr = this.head.next; // 맨 처음부터 검색
            while (i++ < index){
                curr = curr.next;
            }
        } else { // index 가 tail 쪽에 가까울 때
            curr = this.tail.prev; // 맨 끝에서 부터 검색
            while(i++ < (this.size - index - 1)) {
                curr = curr.prev;
            }
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
        return this.head.next == this.tail;
    }

    @Override
    public boolean contains(T t) {
        Node curr = this.head.next;
        Node next = this.tail.prev;

        while ( curr != null || next != null){
            if (curr.data != null && curr.data.equals(t)){
                return true;
            }
            if (next.data != null && next.data.equals(t)){
                return true;
            }
            curr = curr.next;
            next = next.prev;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
    private class Node {
        T data;
        Node prev;
        Node next;
        Node(T data) {
            this.data = data;
        }
        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }
}
