import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline mockFeline; // Мок зависимости Feline для использования в тестах

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(mockFeline);
    }

    // Тест проверяет корректность возвращаемого звука кота
    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    // Тест проверяет, что Cat использует метод eatMeat() класса Feline для получения списка еды
    @Test
    public void testGetFoodCallsEatMeatOfFeline() throws Exception {
        // Настройка мока с предопределенным результатом
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Вызов метода getFood
        List<String> food = cat.getFood();

        // Проверка результата
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);

        // Проверка, что метод eatMeat() был вызван у мока Feline
        verify(mockFeline).eatMeat();
    }
}
