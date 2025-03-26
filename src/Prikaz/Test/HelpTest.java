package Prikaz.Test;

import Prikaz.Help;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpTest {

    @Test
    void testExecute() {
        Help help = new Help();
        String expected ="prikazy, ktere muzes pouzit: jdi, pomoc, konec, pouzit, mluv, prohledat, vzit, vyresit ";
        assertEquals(expected, help.execute());
    }

    @Test
    void exit() {
        Help help = new Help();
        assertFalse(help.exit());
    }
}