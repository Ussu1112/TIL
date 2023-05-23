package OnlineClass.queue;

public class MyLinkedQueue<T> implements IQueue<T> {

    private Node head;
    public Node tail;
    private int size;

    public MyLinkedQueue() {
        this.size = 0;
        this.head = new Node(null); //dummy
        this.tail = this.head;
    }

    @Override
    public void offer(T data) {  //add 라고도 사용
        Node node = new Node(data);
        this.tail.next = node;
        this.tail = this.tail.next; // 가장 마지막에 들어온 값을 tail 로 가지고 있는다.
        this.size++;
    }

    @Override
    public T poll() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        Node node = this.head.next; // 맨 처음에 값이 들어온 위치
        this.head.next = node.next; // 그 뒤에 값을 연결 시켜준다.
        node.next = null;
        this.size--;

        if(this.head.next == null){
            this.tail = this.head;
        }
        return node.data;
    }

    @Override
    public T peak() {
        // 꺼내지 않고 가장 앞에 있는 데이터 확인
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = new Node(null); //dummy
        this.tail = this.head;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    private class Node{
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
