import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> data;
    private int maxSize;

    public Queue(){
        data = new ArrayList<>();
    }

    public boolean isEmpty(){
        return (this.data.size() == 0);
    }

    public boolean isFull(){
        return (this.data.size() == maxSize);
    }

    public void push(T toPush){
        guardAgainstBeingFull();
        data.add(toPush);
    }

    public T pop(){
        guardAgainstBeingEmpty();
        T toGoOut = this.front();
        data.remove(0);
        return toGoOut;
    }

    public T front(){
        guardAgainstBeingEmpty();
        return (this.data.get(0));
    }

    public int size(){
        return (this.data.size());
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    private void guardAgainstBeingEmpty() {
        if (this.isEmpty()) {
            throw new QueueEmptyException();
        }
    }

    private void guardAgainstBeingFull(){
        if (this.isFull()) {
            throw new QueueFullException();
        }
    }

}
