import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    // Тест для метода eatMeat(), проверяет, что метод eatMeat() возвращает предопределенный список пищи для хищников.
    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    // Тест для метода getFamily() проверяет, что метод getFamily() возвращает правильное название семейства, к которому принадлежит животное.
    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, feline.getFamily());
    }

    // (этот нельзя параметризировать, так как аргумент не передать)Тест для метода getKittens() без аргументов, проверяем что возвращает 1 (значение по умолчанию для количества котят в классе)
    @Test
    public void testGetKittensNoArgument() {
        int expectedKittens = 1;
        assertEquals(expectedKittens, feline.getKittens());
    }

    // (параметризирован) Тест для метода getKittens(int kittensCount) с аргументом
    @Test
    public void testGetKittensWithArgument() {
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

}
