import com.sun.deploy.net.proxy.StaticProxyManager;

import java.util.ArrayList;

public class Stack {
    ArrayList<Integer> data;
    int maxSize;

    public Stack(){
        data = new ArrayList<Integer>();
        maxSize = 5;
    }

    public boolean isEmpty(){
        return (this.data.size() == 0);
    }

    public boolean isFull(){
        return (this.data.size() == maxSize);
    }

    public void push (int toPush){
        guardAgainstBeingFull();
        data.add(toPush);
    }

    public int pop (){
        guardAgainstBeingEmpty();
        int topIndex = this.data.size() - 1;
        int toGoOut = this.data.get(topIndex);
        this.data.remove(topIndex);
        return toGoOut;
    }

    public int top(){
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
