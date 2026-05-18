package test_Stack;


public class Stack<T> {
    private Object[] data;
    private int size; 
    
    public Stack() {
        data = new Object[10];
        size = 0;
    }

    public void push( T item) {
        if (size == data.length) grow();
        data[size++] = item;
    }

    private void grow() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data =newData;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T item = (T) data[--size];
        data[size] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return (T) data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
