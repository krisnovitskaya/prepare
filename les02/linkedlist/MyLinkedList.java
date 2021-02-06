package les2.linkedlist;

import les2.MyList;

public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(E item) {
        if(size == 0){
            Node<E> newNode = new Node<>(item, null, null);
            this.first = newNode;
            this.last = newNode;
            size++;
        }else{
            Node<E> newNode = new Node<>(item, null, this.last);
            this.last.next = newNode;
            this.last = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        Node<E> current = this.first;
        int curIndex = 0;
        while (!(curIndex == index)){
            curIndex++;
            current = current.next;
        }
        return current.item;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index > size - 1) throw new IndexOutOfBoundsException();

        Node<E> current = this.first;
        int curIndex = 0;
        while (!(curIndex == index)){
           curIndex++;
           current = current.next;
        }
        if(current == this.first){
            this.first = current.next;
            current.next.previous = null;
        }else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.previous = null;
        }
        current.next = null;
        size--;
        return current.item;

    }

    @Override
    public boolean remove(E item) {
        Node<E> current = this.first;
        while (current != null){
            if(current.item.equals(item)){
                current.previous.next = current.next;
                current.next = null;
                current.previous = null;
                current.item = null;
                size--;
                return true;
            }else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E item) {
        Node<E> current = this.first;
        while (current != null){
            if(current.item.equals(item)){
                return true;
            }else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E item) {
        if(size == 0) return -1;

        Node<E> current = this.first;
        int index = 0;
        while (current != null){
            if(current.item.equals(item)){
                return index;
            }else {
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}
