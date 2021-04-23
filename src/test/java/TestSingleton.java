import com.es2.singleton.*;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class TestSingleton {

    private final Registry r = Registry.getInstance();

    @Test
    public void testSetPathCorrectReturn() {
        String path = "path_test";
        r.setPath(path);
        assertEquals(path, r.getPath());
    }

    @Test
    public void testSetConnectionStringCorrectReturn() {
        String connectionString = "connectionString_test";
        r.setConnectionString(connectionString);
        assertEquals(connectionString, r.getConnectionString());
    }

    @Test
    public void testSetPathNullValue() {
        r.setPath(null);
        assertNull(r.getPath());
    }

    @Test
    public void testSetConnectionStringNullValue() {
        r.setConnectionString(null);
        assertNull(r.getConnectionString());
    }

    @Test
    public void testPrivateConstructor() throws NoSuchMethodException {
        Constructor<Registry> c = Registry.class.getDeclaredConstructor();
        if(c.canAccess(null))
            fail();
    }

    @AfterAll
    public static void tearDown(){
        End e = new End();
    }
}