import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> data;

    public Queue(){
        data = new ArrayList<Integer>();
    }

    public boolean isEmpty(){
        return (this.data.size() == 0);
    }

    public void push(int topush){
        data.add(topush);
    }

    public int pop(){
        int rearIndex = data.size() -1;
        int toGoOut = data.get(rearIndex);
        data.remove(rearIndex);
        return toGoOut;
    }

}
