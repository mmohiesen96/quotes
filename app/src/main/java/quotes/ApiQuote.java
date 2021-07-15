package quotes;

public class ApiQuote {
    private String quoteText;
    private String quoteAuthor;

    public ApiQuote(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    @Override
    public String toString() {
        return "ApiQuote{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}
