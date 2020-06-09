package lists;

public class DoublyLinkedList<T> implements Listable<T> {
    Node head = null;
    Node tail = null;
    int size = 0;

    private class Node {
        T data;
        Node next;
        Node prev;

        private Node(T dat, Node n, Node p){
            data = dat;
            next = n;
            prev = p;
        }
         void setLinkNext(Node n) {
            next = n;
        }

         void setLinkPrev(Node p) {
            prev = p;
        }
         Node getLinkNext() {
            return next;
        }
         T getData() {
            return data;
        }


    }
    @Override
    public void add(T data) {
        Node temp = new Node(data, null, null);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            temp.setLinkPrev(tail);
            tail.setLinkNext(temp);
            tail = temp;
        }
        size++;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Exception");
        Node newNode = new Node(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        else {
            Node nodeRef = head;
            for (int i = 1; i < index; i++)
                nodeRef = nodeRef.next;

            newNode.next = nodeRef.next;
            nodeRef.next = newNode;
            newNode.prev = nodeRef;
            newNode.next.prev = newNode;
        }
        size++;
    }




    @Override
    public void addFirst(T data) {
        Node temp = new Node(data, null, null);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            head.setLinkPrev(temp);
            temp.setLinkNext(head);
            head = temp;
        }
        size++;
    }


    @Override
    public void addLast(T data) {
        Node temp = new Node(data, null, null);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            temp.setLinkPrev(tail);
            tail.setLinkNext(temp);
            tail = temp;
        }
        size++;
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
        if (index < 0 || index >= size()) {
            return null;
        }
        if (index == 0) {
            return head.data;
        }
        if (index == size - 1) {
            return tail.data;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }



    @Override
    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node remove = head;
        for (int i = 0; i < index; i++) {
            remove = remove.next;
        }
        if (index == 0) {
            if (size == 1) {
                this.clear();
            }
            head = head.next;
            head.prev = null;
            size--;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
        } else {
            remove.next.prev = remove.prev;
            remove.prev.next = remove.next;
            size--;
        }
    }


    @Override
    public void clear() {
        Node node = head;
        while (node != null) {
            Node next = node.next;
            node.prev = node.next = null;
            node.data = null;
            node = next;
        }
        head = tail = null;
        size = 0;


    }

    @Override
    public int size() {
        size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
    return size;
    }

    @Override
    public void printAll() {
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.getLinkNext() == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
        System.out.print(head.getData() + "\n");
        ptr = head.getLinkNext();
        while (ptr.getLinkNext() != null) {
            System.out.print(ptr.getData() + "\n");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + "\n");


    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }
}