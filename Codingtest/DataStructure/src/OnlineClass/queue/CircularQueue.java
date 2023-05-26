package OnlineClass.queue;

public class CircularQueue<T> implements IQueue<T> {

    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    public CircularQueue(int size){
        // T타입의 배열에 isFull 과 isEmpty를 구분하기위해 더미공간 한칸을 둔다.
        this.elements = (T[]) new Object[size+1];
        this.front = 0;
        this.rear = 0;
        this.maxSize = size + 1;
    }

    @Override
    public void offer(T data) {
        //enqueue - rear가 다음 배열칸을 가리키고 그곳에 값을넣는다.
        if(this.isFull()){
            throw new IllegalStateException();
        }
        this.rear = (this.rear + 1) % this.maxSize;
        this.elements[this.rear] = data;
    }

    @Override
    public T poll() {
        //dequeue - front가 한칸 씩 전진 하면서 dequeue
        if (this.isEmpty()){
            throw new IllegalStateException();
        }
        this.front = (this.front + 1) % this.maxSize;
        return this.elements[this.front];
    }

    @Override
    public T peak() {
        if (this.isEmpty()){
            throw new IllegalStateException();
        }

        return this.elements[this.front + 1];
    }

    @Override
    public int size() {
        if (this.front <= this.rear){
            return this.rear - this.front;
        }
        return this.maxSize - this.front + this.rear;
    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    private boolean isFull(){
        //this.rear + 1 -> 인덱스 범위를 벗아날 수 있기 때문에
        return (this.rear + 1) % this.maxSize == this.front;
    }
}
