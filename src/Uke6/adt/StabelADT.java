package Uke6.adt;

public interface StabelADT<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}
