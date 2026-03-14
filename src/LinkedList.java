public class LinkedList<Task> implements List<Task> {

    private class Node<Task> {
        private Task nodeTask;
        private Node next;

        public Node(Task task) {
            this.nodeTask = task;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = head;
    private int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(Task task) {
        Node newNode = new Node(task);

        if (this.isEmpty()) {
            head = newNode;
            tail = head;
            n++;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
            n++;
        }
    }

    @Override
    public void remove(int ID) {
        if (isEmpty()) {
            System.out.println("There are no tasks due on that date");
            return;
        }
        else {
            Node nodeToRemove = head;
            //while () //While ID != task.getID() node = node.next;
        }
    }

}
