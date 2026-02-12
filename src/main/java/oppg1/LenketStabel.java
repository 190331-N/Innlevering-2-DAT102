package oppg1;

import java.util.EmptyStackException;

public class LenketStabel<T> implements StabelADT<T> {

        private static class Node<T> {
            T data;
            Node<T> next;
            Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node<T> top;

        @Override
        public void push(T value) {
            top = new Node<>(value, top);
        }

        @Override
        public T pop() {
            if (isEmpty()) throw new EmptyStackException();
            T value = top.data;
            top = top.next;
            return value;
        }

        @Override
        public T peek() {
            if (isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        @Override
        public boolean isEmpty() {
            return top == null;
        }

        @Override
        public void clear() {
            top = null;
        }
}
