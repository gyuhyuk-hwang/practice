public class Main3 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        //plus
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        //delete
        int item = queue.dequeue();
        System.out.println("item = " + item);

        //peek
        int peekItem = queue.peek();
        System.out.println("peekItem = " + peekItem);

        //exception
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
