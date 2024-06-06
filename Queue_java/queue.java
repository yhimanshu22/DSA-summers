import java.util.*;

public class queue {
    public static void main(String[] args) {
        // creating a queue------>
        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q = new PriorityQueue<>();

        // adding a element
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(4);

        // print the queue-------->
        System.out.println("Queue: " + q);

        // remove and print element until the queue is empty
        // while (!q.isEmpty()) {
        // System.out.println(q.remove());
        // }

        // print the queue after removal
        // System.out.println("queue after removal: " + q);

        // access the element at front of the queue without removing it
        System.out.println("front element: " + q.peek());

        // Access the element at the front of the Queue without removing it using
        // element()
        int frontElement = q.element();
        System.out.println("Element at front: " + frontElement);

        // size of the queue
        System.out.println("size of the queue: " + q.size());

        // Checking if Queue is empty
        System.out.println("Is Queue empty? " + q.isEmpty());

        // Clear the Queue
        q.clear();

        System.out.println("Is Queue empty? " + q.isEmpty());

    }
}
