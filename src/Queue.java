import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> data;
    int maxSize;

    public Queue(){
        data = new ArrayList<T>();
        maxSize = 5;
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
        T toGoOut = this.floor();
        data.remove(0);
        return toGoOut;
    }

    public T floor(){
        guardAgainstBeingEmpty();
        return (this.data.get(0));
    }

    public int size(){
        return (this.data.size());
    }

    private void guardAgainstBeingEmpty() {
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }
    }

    private void guardAgainstBeingFull(){
        if (this.isFull()) {
            throw new StackFullException();
        }
    }

}
