package les2.arraylist;


import les2.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private final static int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;


    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void add(E item) {
        checkAndGrow();
        data[size++] = item;
    }

    private void checkAndGrow() {
        if (size == data.length) {
            data = Arrays.copyOf(data, getNewLength());
        }
    }

    private int getNewLength() {
        return size > 0 ? size * 2 : 1;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        E item = data[index];
        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public boolean remove(E item) {
        int index = indexOf(item);

        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) return i;
        }
        return -1;
    }
}
