package seminar04.test;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Task1 {

//    Создать мок-объект Iterator, настроить поведение так, чтобы за два вызова next() Iterator
//    вернул два слова “Hello World”, и проверить это поведение с помощью утверждений

    @Test
    public void testIterator() {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello").thenReturn("World!");
        String result = iterator.next() + " " + iterator.next();
        assertThat(result).isEqualTo("Hello World!");
    }
}
