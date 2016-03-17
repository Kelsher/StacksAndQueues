import org.junit.Test;

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

        assertTrue(q.data.size() == 1);
        assertFalse(q.isEmpty());
    }

    @Test
    public void will_pop_one_item(){
        Queue q = new Queue();

        q.push(5);
        q.pop();

        assertEquals(q.pop(), 5);
    }
}
