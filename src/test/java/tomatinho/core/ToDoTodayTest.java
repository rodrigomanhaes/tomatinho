package tomatinho.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ToDoTodayTest {
    
    private String preAddedTask1, preAddedTask2;
    private ToDoToday todo;
    
    @Before
    public void setup() {
        preAddedTask1 = "Write article on 'How to Learn Music'";
        preAddedTask2 = "Finetune 'How to Learn Music' by reading out loud";
        todo = new ToDoToday(preAddedTask1, preAddedTask2);
    }

    @Test
    public void testRequiresAnInitialToDoList() {
        assertThat(todo.tasks(), hasItems(preAddedTask1, preAddedTask2));
    }
    
    @Test
    public void acceptsAdditionOfItems() {
        todo.addItem("Another thing to do");
        assertThat(todo.tasks(), 
            hasItems(preAddedTask1, preAddedTask2, "Another thing to do"));
    }
}