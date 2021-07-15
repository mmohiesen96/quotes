package quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Api {
    private String Url;

    public Api(String url) {
        Url = url;
    }

    public HttpURLConnection connect () throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(this.Url).openConnection();

        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        return con;
    }

    public BufferedReader readData() throws IOException {
        InputStreamReader input = new InputStreamReader(connect().getInputStream());
        BufferedReader br = new BufferedReader(input);
        return br;
    }
}
