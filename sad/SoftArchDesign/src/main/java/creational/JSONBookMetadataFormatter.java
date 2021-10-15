package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject bookObject;
    private JSONObject book;
    private JSONArray bookArray;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        bookObject = new JSONObject();
        bookArray = new JSONArray();
        bookObject.put("Books",bookArray);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        List<String> authors = new ArrayList<String>(Arrays.asList(b.getAuthors()));
        book = new JSONObject();
        book.put("ISBN", b.getISBN());
        book.put("Authors",authors );
        book.put("Title", b.getTitle());
        book.put("Publisher", b.getPublisher());
        bookArray.add(book);
        
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return bookObject.toString();
    }
}
