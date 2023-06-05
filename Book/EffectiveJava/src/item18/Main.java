package item18;

import java.util.HashSet;
import java.util.List;

import java.util.Collection;
import java.util.HashSet;

class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet() {
        super();
    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

public class Main {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));

        System.out.println(s.getAddCount());

        InstrumentedSet<String> s2 = new InstrumentedSet<>(new HashSet<>());
        s2.addAll(List.of("틱", "탁탁", "펑"));

        System.out.println(s2.getAddCount());


    }
}
