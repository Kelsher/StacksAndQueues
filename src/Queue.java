import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> data;
    int maxSize;

    public Queue(){
        data = new ArrayList<Integer>();
        maxSize = 5;
    }

    public boolean isEmpty(){
        return (this.data.size() == 0);
    }

    public boolean isFull(){
        return (this.data.size() == maxSize);
    }

    public void push(int toPush){
        guardAgainstBeingFull();
        data.add(toPush);
    }

    public int pop(){
        guardAgainstBeingEmpty();
        int toGoOut = this.bottom();
        data.remove(0);
        return toGoOut;
    }

    public int bottom(){
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
