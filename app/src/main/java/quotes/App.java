/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Stack;

public class App {
    public Quote getRandomQuotes (String path) throws IOException{
        /*
          Min and max variables to declare the math.random number from 0 to 137 which is the indexes .
         */
        int min = 0 , max = 137;
        /*
          object of the Gson library to read the json file.
         */
        Gson gson = new Gson();
        /*
           Read the json file using buffered reader class
         */
        BufferedReader reader = new BufferedReader(new FileReader(path));
        /*
          Declare a list of type Quote , call the method fromJson using the gson object , send the reader as an arg with the a TypeToken that holds
          the List of quotes and .getType to return the type of the list that is required
         */

        List<Quote> quote =  gson.fromJson(reader , new TypeToken<List<Quote>>() {}.getType());
        /**
         * Close the reader .
         */
        reader.close();
        return quote.get((int) (Math.random()*(max-min+1)+min));
    }
    public static void main(String[] args) throws IOException {
        try {
            Api quoteApi = new Api("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection con = quoteApi.connect();
            int resCode = con.getResponseCode();
            BufferedReader br = quoteApi.readData();
            Gson gson = new Gson();

            BufferedReader reader = new BufferedReader(new FileReader("./app/src/main/java/quotes/recentquotes.json"));
            List<Quote> quotes =  gson.fromJson(reader , new TypeToken<List<Quote>>() {}.getType());
            BufferedWriter bw = new BufferedWriter(new FileWriter("./app/src/main/java/quotes/recentquotes.json" , false));
            ApiQuote quoteData = gson.fromJson(br , ApiQuote.class);
            Quote quote = new Quote(null , quoteData.getQuoteAuthor() , null , quoteData.getQuoteText());
            quotes.add(quote);
            gson = gson.newBuilder().setPrettyPrinting().create();
            String newQuotes = gson.toJson(quotes);
            String apiQuote = gson.toJson(quote);
            System.out.println(apiQuote);
            System.out.println("From API ");
            bw.write(newQuotes);
            bw.close();
            br.close();
        }
            catch (Exception e ) {
                System.out.println("From local machine");
                System.out.println(new App().getRandomQuotes("./app/src/main/java/quotes/recentquotes.json") );
            }

    }
}
