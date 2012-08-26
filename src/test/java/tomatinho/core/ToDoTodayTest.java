package tomatinho.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.*;

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
    public void addTaskAsUnplanned() {
        Task task = new Task("An urgent thing I only remembered right now");
        todo.addUnplannedItem(task);
        assertThat(todo.unplannedTasks().size(), is(1));
        assertThat(todo.unplannedTasks(), hasItems(task));
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

    @Test
    public void hasOwnerLocalAndDate() {
        Date thisDate = new Date(System.currentTimeMillis());
        todo
            .owner("Bruce Wayne")
            .local("Gotham City")
            .date(thisDate);
        assertThat(todo.owner(), is("Bruce Wayne"));
        assertThat(todo.local(), is("Gotham City"));
        assertThat(todo.date(), is(thisDate));
    }
}