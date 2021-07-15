package quotes;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.Arrays;

public class Quote {
    private String[] tags;
    private String author;
    private String likes;
    private String text;

    public Quote(String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    @Override
    public String toString() {
        return this.author + " : " + this.text;
    }

    public String[] getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }
}
