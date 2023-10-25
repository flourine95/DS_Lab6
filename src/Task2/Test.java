package Task2;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addLast(4);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.printNodes();
        list.removeFirst();
        list.printNodes();
        list.removeLast();
        list.printNodes();
    }
}
