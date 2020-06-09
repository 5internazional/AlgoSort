package lists;

public class SinglyLinkedList<T> implements Listable<T> {
    Node head = null;

    private class Node {
        T data;
        Node next;
    }

    @Override
    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    @Override
    public void add(int index, T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (this.head == null) {
            if (index != 0) {
                return;
            } else {
                this.head = node;
            }
        }

        if (head != null && index == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }

        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < index) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }

            i++;
        }

        node.next = current;
        previous.next = node;
    }
    @Override
    public void addFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;

    }

    @Override
    public void addLast(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

    }

    @Override
    public void set(int index, T data) {
        if (index < 0 || index > this.size()) {
            System.out.println("Index is wrong!");
        }
        Node temp = head;
        if (!isEmpty()) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.data = data;
        } else
            System.out.println("List is empty!");
    }

    @Override
    public T get(int index) {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            if (counter == index) {
                return temp.data;
            }
            counter++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void remove(int index) {
        if (head == null)
            return;
        Node temp = head;
        if (index == 0) {
            head = temp.next;
            return;
        }
        for (int i=0; temp!=null && i<index-1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;

        temp.next = next;
    }


    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;     }
}