package tomatinho.core;

import org.junit.Before;
import static org.mockito.Mockito.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ToDoTodayTest {
    
    private Task preAddedTask1, preAddedTask2;
    private ToDoToday todo;
    
    @Before
    public void setup() {
        preAddedTask1 = new Task("Write article on 'How to Learn Music'");
        preAddedTask2 = new Task("Finetune 'How to Learn Music' by reading out loud");
        todo = new ToDoToday(preAddedTask1, preAddedTask2);
    }

    @Test
    public void testRequiresAnInitialToDoList() {
        assertThat(todo.tasks(), hasItems(preAddedTask1, preAddedTask2));
    }
    
    @Test
    public void acceptsAdditionOfItems() {
        Task anotherTask = new Task("Another thing to do");
        todo.addItem(anotherTask);
        assertThat(todo.tasks(), 
            hasItems(preAddedTask1, preAddedTask2, anotherTask));
    }
    
    @Test
    public void retrievesCurrentTaskOrNext() {
        Task task1 = mock(Task.class);
        when(task1.finished()).thenReturn(false, false, true);
        Task task2 = mock(Task.class);
        when(task2.finished()).thenReturn(false);
        ToDoToday todo = new ToDoToday(task1, task2);
        assertThat(todo.currentOrNext(), is(task1));
        assertThat(todo.currentOrNext(), is(task1));
        assertThat(todo.currentOrNext(), is(task2));
    }
}