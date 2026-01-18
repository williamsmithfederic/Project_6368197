package com.democicd1290.democicd1290;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceTest {

    @Test
    void greet_defaultWorldWhenNull() {
        GreetingService s = new GreetingService();
        assertEquals("Hello World", s.greet(null));
    }

    @Test
    void normalize_trimsAndLimitsLength() {
        GreetingService s = new GreetingService();
        String input = "   Alice   ";
        assertEquals("Alice", s.normalize(input));

        String longName = "012345678901234567890123456789XXXX";
        assertEquals(30, s.normalize(longName).length());
    }

    @Test
    void isQuietHours_trueAtNight_falseAtDay() {
        GreetingService s = new GreetingService();
        assertTrue(s.isQuietHours(LocalTime.of(23, 0)));
        assertTrue(s.isQuietHours(LocalTime.of(5, 59)));
        assertFalse(s.isQuietHours(LocalTime.of(12, 0)));
    }
}