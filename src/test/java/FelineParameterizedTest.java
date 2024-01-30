import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private int inputKittensCount; // Входное количество котят для теста
    private int expectedKittensCount; // Ожидаемое количество котят, которое должен вернуть метод
    private Feline feline;

    public FelineParameterizedTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, // Тест с 0 котятами
                { 1, 1 }, // Тест с 1 котенком
                { 5, 5 }, // Тест с 5 котятами
                {10, 10}, // Тест с 10 котятами
        });
    }

    @Test
    public void testGetKittensWithDifferentCounts() {
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }
}
