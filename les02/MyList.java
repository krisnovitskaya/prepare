package les2;

public interface MyList<E> {

    void add(E item);

    E get(int index);

    E remove(int index);

    boolean remove(E item);

    boolean contains(E item);

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

    int indexOf(E item);
}
