import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;

    private int size = 0;

    /*
    add(): MyLinkedList 의 마지막 노드에 data 를 추가 할 수 있습니다.
    delete(index i): MyLinkedList 의 i 번째 노드의 데이터를 삭제합니다.
     */

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (size == 0){
            head = node;
        }
        else{
            Node<T> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }

            //현재 current 에는 가장 마지막 Node 가 위치하고 있음
            current.setNext(node);
        }
        this.size++;
    }

    //get(index i): MyLinkedList 의 i 번째 노드의 data 를 return 합니다.
    public T get(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        //index 번째 노드를 찾음
        Node<T> current = this.head;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getData();
    }

    //delete(index i): MyLinkedList 의 i 번째 노드의 데이터를 삭제합니다.
    //중간 것 삭제 시 해당 노드를 가리키는 주소를 정리해줘야함
    // 1 -> 2 -> 3 -> 4
    // 3번 삭제 시 바로 2 > 4

    public void delete(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            head = head.getNext();
        }
        else{
            //index번째 노드를 찾는다.
            Node<T> current = this.head;
            for(int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            //직전 노드의 next 를 i+1 번째 노드로 바꿔준다.
            current.setNext(current.getNext().getNext());
        }
        this.size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {return current != null;}

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T data = current.getData();
                current = current.getNext();

                return data;
            }
        };
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


}
