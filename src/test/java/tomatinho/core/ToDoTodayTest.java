package tomatinho.core;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ToDoTodayTest {

    @Test
    public void testRequiresAnInitialToDoList() {
        String task1 = "Write article on 'How to Learn Music'";
        String task2 = "Finetune 'How to Learn Music' by reading out loud"; 
        ToDoToday todo = new ToDoToday(task1, task2);
        assertThat(todo.tasks(), hasItems(task1, task2));
    }

}