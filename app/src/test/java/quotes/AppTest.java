/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    Quote quote;App classUnderTest;
    String path;
    Gson gson;
    BufferedReader reader;
    List<Quote> quotes;
    @BeforeEach
    public void init() throws IOException {
        classUnderTest = new App();
       path = "./src/test/java/quotes/recentquotes.json";
        gson = new Gson();
        reader = new BufferedReader(new FileReader(path));
        quotes =  gson.fromJson(reader , new TypeToken<List<Quote>>() {}.getType());
    }


    @Test
    public void testConstructor() {
        /**
         * Tests if the constructor initializes the given values correctly .
         */
    quote = new Quote(new String[]{"test1 , test2"}, "testAuthor" , "testLikes" , "testText");
    assertArrayEquals(new String[]{"test1 , test2"} , quote.getTags());
        assertEquals("testAuthor" , quote.getAuthor());
        assertEquals("testLikes" , quote.getLikes());
        assertEquals("testText" , quote.getText());

    }

    @RepeatedTest(100)
    public void testFunctionality() throws IOException{
        quote = classUnderTest.getRandomQuotes(path);
        int index = 0;
        for (int i = 0; i < quotes.size() ; i++) {
            if(quotes.get(i).getText().equals(quote.getText())){
                index = i;
            }
        }

        assertTrue(index >= 0 && index < 138 , "return true if successfully got a random quote from the json file ");
    }

    @Test
    public void testNullFile () {
        assertNotNull(reader , "Return true if the reader is not null");
    }
}
