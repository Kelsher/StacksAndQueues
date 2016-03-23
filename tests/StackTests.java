import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTests {

    @Test
    public void will_create_an_empty_stack(){
        Stack<Integer> s = new Stack();

        assertTrue(s.isEmpty());
    }

    @Test
    public void can_push_one_item_to_the_stack(){
        Stack<Integer> s = new Stack();

        s.push(5);

        assertEquals(1,s.size());
        assertFalse(s.isEmpty());
    }

    @Test
    public void can_pop_one_item(){
        Stack<Integer> s = new Stack();

        s.push(5);

        assertEquals(5,s.pop());
        assertTrue(s.isEmpty());
    }

    @Test(expected = StackEmptyException.class)
    public void we_can_get_last_entry_of_empty_stack(){
        Stack<Integer> s = new Stack();

        s.top();
    }

    @Test
    public void we_can_get_last_entry_of_stack_with_values(){
        Stack<Integer> s = new Stack();

        s.push(7);

        assertEquals(7, s.top());
    }

    @Test(expected = StackEmptyException.class)
    public void can_we_pop_an_empty_stack(){
        Stack<Integer> s = new Stack();

        s.pop();
    }

    @Test
    public void can_we_push_multiple_items(){
        Stack<Integer> s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        assertEquals(4, s.size());
        assertFalse(s.isEmpty());
    }

    //Also tests to see if it follows the FILO order
    @Test
    public void can_we_pop_mutiple_items(){
        Stack<Integer> s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(s.pop(), 3);
        assertEquals(s.pop(), 2);
        assertEquals(s.pop(), 1);
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
    }

    @Test(expected = StackEmptyException.class)
    public void can_we_pop_more_than_we_pushed(){
        Stack<Integer> s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }

    @Test
    public void we_can_check_if_stack_is_full(){
        Stack<Integer> s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        assertTrue(s.isFull());
    }

    @Test(expected = StackFullException.class)
    public void we_cant_overflow_the_stack(){
        Stack<Integer> s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        assertEquals(5, s.size());
    }


    @Test
    public void we_can_get_the_size_of_an_empty_stack(){
        Stack<Integer> s = new Stack();

        assertEquals(0, s.size());
    }

    @Test
    public void we_can_get_the_size_of_an_full_stack(){
        Stack<Integer> s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        assertEquals(5, s.size());
    }

    @Test
    public void can_we_use_string_in_our_stack(){
        Stack<String> s = new Stack<>();

        s.push("Tarzan");
        s.push("Yogurt");
        s.push("L-dawg");

        assertEquals(3, s.size());
        assertEquals("Tarzan", s.pop());
        assertEquals("Yogurt", s.pop());
        assertEquals("L-dawg", s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    public void can_we_use_boolean_in_our_queue(){
        Stack<Boolean> s = new Stack<>();

        s.push(true);
        s.push(false);
        s.push(true);

        assertEquals(3, s.size());
        assertEquals(true, s.pop());
        assertEquals(false, s.pop());
        assertEquals(true, s.pop());
        assertTrue(s.isEmpty());
    }
}
