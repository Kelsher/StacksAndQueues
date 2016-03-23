import com.sun.deploy.net.proxy.StaticProxyManager;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> data;
    int maxSize;

    public Stack(){
        data = new ArrayList<T>();
        maxSize = 5;
    }

    public boolean isEmpty(){
        return (this.data.size() == 0);
    }

    public boolean isFull(){
        return (this.data.size() == maxSize);
    }

    public void push (T toPush){
        guardAgainstBeingFull();
        data.add(toPush);
    }

    public T pop (){
        guardAgainstBeingEmpty();
        int topIndex = this.data.size() - 1;
        T toGoOut = this.data.get(topIndex);
        this.data.remove(topIndex);
        return toGoOut;
    }

    public T top(){
        guardAgainstBeingEmpty();
        int topIndex = this.data.size() - 1;
        return (this.data.get(topIndex));
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
