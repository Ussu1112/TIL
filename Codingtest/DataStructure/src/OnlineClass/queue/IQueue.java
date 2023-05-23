package OnlineClass.queue;

public interface IQueue<T> {

    void offer(T data);
    T poll();
    T peak();
    int size();
    void clear();
    boolean isEmpty();

}
