package Prikaz.Test;

import Prikaz.Exit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ExitTest {

    @Test
    void execute() {
        Exit exit = new Exit();
        String expected = "Hra ukončena";
        assertEquals(expected, exit.execute());
    }

    @Test
    void exit() {
        Exit exit = new Exit();
        assertTrue(exit.exit());
    }
}