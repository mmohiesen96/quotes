package quotes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestQuotes {
    Api api;
    /*
    Test constructor and initialization
     */
    @BeforeEach
    public void init() {
        api = new Api("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
    }
    /*
    Test Connection
     */
    @Test
    public void testConnection() throws IOException {
        Assertions.assertEquals(200 , api.connect().getResponseCode());
    }

    /*
    Test reading data
     */
    @Test
    public void testRead() throws IOException {
        Assertions.assertNotNull(api.readData());
    }


}
