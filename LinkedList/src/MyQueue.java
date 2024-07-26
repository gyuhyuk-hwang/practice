import java.util.NoSuchElementException;

public class MyQueue<T>{
    private MyLinkedList<T> list = new MyLinkedList<>();

    //enqueue
    public void enqueue(T item){ list.add(item); }
    //dequeue
    public T dequeue(){
        if(list.isEmpty()){
            throw new NoSuchElementException("empty queue");
        }
        T frontItem = list.get(0);
        list.delete(0);
        return frontItem;
    }

    //peek
    public T peek(){
        if(list.isEmpty()){
            throw new NoSuchElementException("empty queue");
        }
        T frontItem = list.get(0);
        return frontItem;
    }
}
