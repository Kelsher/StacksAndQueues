import org.junit.Test;
import sun.misc.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTests {

    @Test
    public void will_create_an_empty_queue(){
        Queue q = new Queue();
        q.setMaxSize(5);

        assertTrue(q.isEmpty());
    }

    @Test
    public void will_push_one_item_to_the_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(5);

        assertEquals(1,q.size());
        assertFalse(q.isEmpty());
    }

    @Test
    public void will_pop_one_item() {
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(5);

        assertTrue(5 == q.pop());
        assertTrue(q.isEmpty());
    }
    @Test(expected = QueueEmptyException.class)
    public void can_we_get_floor_of_empty_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.front();
    }

    @Test
    public void can_we_get_floor_of_queue_with_values(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(5);

        assertTrue(5 == q.front());
    }

    @Test(expected = QueueEmptyException.class)
    public void can_we_pop_an_empty_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.pop();
    }

    @Test
    public void can_we_push_multiple_items(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(2);
        q.push(3);
        q.push(4);

        assertFalse(q.isEmpty());
        assertEquals(3, q.size());
    }

    //Also Tests to see if it follows the correct FIFO order
    @Test
    public void can_we_pop_multiple_items(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(1);
        q.push(2);
        q.push(3);

        assertTrue(1 == q.pop());
        assertTrue(2 == q.pop());
        assertTrue(3 == q.pop());
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
    }

    @Test(expected = QueueEmptyException.class)
    public void can_we_pop_more_than_we_push(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        q.pop();
        q.pop();
        q.pop();
    }

    @Test
    public void can_check_if_queue_is_full(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        assertTrue(q.isFull());
    }

    @Test(expected = QueueFullException.class)
    public void can_we_overflow_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);

        assertEquals(5, q.size());
    }

    @Test
    public void can_we_get_size_of_empty_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        assertEquals(0, q.size());
    }

    @Test
    public void can_we_get_size_of_full_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(5);

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        assertEquals(5,q.size());
    }

    @Test
    public void can_we_use_string_in_our_queue(){
        Queue<String> q = new Queue<>();
        q.setMaxSize(5);

        q.push("Tarzan");
        q.push("Yogurt");
        q.push("L-dawg");

        assertEquals(3, q.size());
        assertEquals("Tarzan", q.pop());
        assertEquals("Yogurt", q.pop());
        assertEquals("L-dawg", q.pop());
        assertTrue(q.isEmpty());
    }

    @Test
    public void can_we_use_boolean_in_our_queue(){
        Queue<Boolean> q = new Queue<>();
        q.setMaxSize(5);

        q.push(true);
        q.push(false);
        q.push(true);

        assertEquals(3, q.size());
        assertTrue(q.pop());
        assertFalse(q.pop());
        assertTrue(q.pop());
        assertTrue(q.isEmpty());
    }

    @Test
    public void can_we_make_a_queue_size_zero(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(0);
    }

    @Test(expected = QueueFullException.class)
    public void can_we_add_to_a_zero_size_queue(){
        Queue<Integer> q = new Queue<>();
        q.setMaxSize(0);

        q.push(5);
    }

    @Test(expected = QueueEmptyException.class)
    public void can_we_pop_with_undefined_size(){
        Queue<Integer> q = new Queue<>();

        q.pop();
    }

    @Test(expected = QueueFullException.class)
    public void can_we_push_with_undefined_size(){
        Queue<Integer> q = new Queue<>();

        q.push(5);
    }
}
