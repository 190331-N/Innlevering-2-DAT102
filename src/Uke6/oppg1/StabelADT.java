package oppg1;

public interface StabelADT<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}
