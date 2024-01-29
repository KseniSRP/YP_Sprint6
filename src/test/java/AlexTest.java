import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline mockFeline; // Мок зависимости Feline для использования в тестах

    private Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(mockFeline);
    }

    // Тест проверяет, что у Алекса нет детей
    @Test
    public void testAlexNoKittens() {
        assertEquals(0, alex.getKittens());
    }

    // Тест проверяет список друзей Алекса
    @Test
    public void testAlexFriendsList() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    // Тест проверяет место жительства Алекса
    @Test
    public void testAlexLivingPlace() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

}
