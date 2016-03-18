import junit.framework.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTests {

    @Test
    public void will_create_an_empty_queue(){
        Queue q = new Queue();

        assertTrue(q.isEmpty());
    }

    @Test
    public void will_push_one_item_to_the_queue(){
        Queue q = new Queue();

        q.push(5);

        assertEquals(1,q.size());
        assertFalse(q.isEmpty());
    }

    @Test
    public void will_pop_one_item() {
        Queue q = new Queue();

        q.push(5);

        assertEquals(5, q.pop());
        assertTrue(q.isEmpty());
    }
    @Test(expected = StackEmptyException.class)
    public void can_we_get_bottom_of_empty_stack(){
        Queue q = new Queue();

        q.bottom();
    }

    @Test
    public void can_we_get_bottom_of_stack_with_values(){
        Queue q = new Queue();

        q.push(5);

        assertEquals(5,q.bottom());
    }

    @Test(expected = StackEmptyException.class)
    public void can_we_pop_an_empty_queue(){
        Queue q = new Queue();

        q.pop();
    }

    @Test
    public void can_we_push_multiple_items(){
        Queue q = new Queue();

        q.push(2);
        q.push(3);
        q.push(4);

        assertFalse(q.isEmpty());
        assertEquals(3,q.size());
    }

    //Also Tests to see if it follows the correct FIFO order
    @Test
    public void can_we_pop_multiple_items(){
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(3);

        assertEquals(1,q.pop());
        assertEquals(2,q.pop());
        assertEquals(3,q.pop());
        assertTrue(q.isEmpty());
        assertEquals(0,q.size());
    }

    @Test(expected = StackEmptyException.class)
    public void can_we_pop_more_than_we_push(){
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        q.pop();
        q.pop();
        q.pop();
    }

    @Test
    public void can_check_if_stack_is_full(){
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        assertTrue(q.isFull());
    }

    @Test(expected = StackFullException.class)
    public void can_we_overflow_stack(){
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);

        assertEquals(5,q.size());
    }

    @Test
    public void can_we_get_size_of_empty_stack(){
        Queue q = new Queue();

        assertEquals(0,q.size());
    }

    @Test
    public void can_we_get_size_of_full_stack(){
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        assertEquals(5,q.size());
    }
}
