package OnlineClass.stack;

public class MyStack<T> implements IStack<T> {

    private int size;
    private Node head;

    public MyStack() {
        this.size = size();
        // 헤드 값을 더미 노드로 둔다.
        this.head = new Node(null);
    }

    @Override
    public void push(T data) {
        // 제일 끝단에 새로운 노드를 추가해두고
        Node node = new Node(data, this.head.next);
        // 기존에 this.head.next 에 node 를 넣는다.
        this.head.next = node;
        this.size++;
    }

    @Override
    public T pop() {
        // 가장 마지막 데이터를 꺼낸다.
        // head.next 는 항상 가장최근의 값을 가지고있다.
        Node curr = this.head.next;
        this.head.next = curr.next;
        curr.next = null;
        this.size--;
        return curr.data;
    }

    @Override
    public T peek() {
        if (this.isEmpty()){
            return null;
        }
        return this.head.next.data;
    }

    private boolean isEmpty() {
        return this.head.next == null;
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
