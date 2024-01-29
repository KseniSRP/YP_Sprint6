import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline mockFeline; // Мок зависимости Feline для использования в тестах

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", mockFeline); // По умолчанию тестируем со львом
    }

    // Тест проверяет, что у льва есть грива
    @Test
    public void testMaleLionHasMane() throws Exception {
        assertTrue(lion.doesHaveMane());
    }

    // Тест проверяет, что у львицы нет гривы
    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        lion = new Lion("Самка", mockFeline); // Создаем экземпляр львицы для этого теста
        assertFalse(lion.doesHaveMane());
    }

    // Тест на генерацию исключения при неверном поле льва
    @Test(expected = Exception.class)
    public void testExceptionOnInvalidSex() throws Exception {
        new Lion("Кто-то", mockFeline);
    }

    // Тест проверяет, что Lion использует метод getFood() класса Feline
    @Test
    public void testGetFoodCallsFeline() throws Exception {
        // Когда у мок-объекта mockFeline вызван метод getFood с параметром "Хищник", должно вернуть  "Животные", "Птицы", "Рыба"
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Вызов метод getFood
        lion.getFood();

        // Проверка, что метод getFood("Хищник") был вызван у мока Feline
        verify(mockFeline).getFood("Хищник");
    }

    // Тест проверяет, что Lion вызывает метод getKittens() у Feline
    @Test
    public void getKittens_InvokesGetKittensOfFeline() {
        // Настраиваем поведение мок-объекта mockFeline. Когда будет вызван метод getKittens() у mockFeline, он должен возвращать число 3
        when(mockFeline.getKittens()).thenReturn(3);

        //  Проверяем, что метод getKittens() у экзепляра класса Lion возвращает значение 3
        assertEquals(3, lion.getKittens());

        // Подтверждаем что метод getKittens() был вызван на моке ockFeline
        verify(mockFeline).getKittens();
    }
}
