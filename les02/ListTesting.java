package les2;

import les2.arraylist.MyArrayList;
import les2.linkedlist.MyLinkedList;

public class ListTesting {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        //MyList<Integer> list = new MyArrayList<>();

        System.out.println(list.size());

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println(list.size());

        list.add(10);
        System.out.println(list.indexOf(4));
        System.out.println(list.remove(5));

        System.out.println(list.indexOf(5));

        list.remove(Integer.valueOf(6));
        System.out.println(list.contains(6));
    }
}
