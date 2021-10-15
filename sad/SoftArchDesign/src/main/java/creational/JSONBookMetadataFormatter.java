package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject bookObject;
    private JSONObject bookInfo;
    private JSONArray bookArray;

    public JSONBookMetadataFormatter(){
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookObject = new JSONObject();
        bookArray = new JSONArray();
        bookObject.put("Books",bookArray);

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        List<String> authors = new ArrayList<String>(Arrays.asList(b.getAuthors()));
        bookInfo = new JSONObject();
        bookInfo.put("ISBN", b.getISBN());
        bookInfo.put("Authors",authors );
        bookInfo.put("Title", b.getTitle());
        bookInfo.put("Publisher", b.getPublisher());
        bookArray.add(bookInfo);

        return this;
    }

    @Override
    public String getMetadataString() {
        return bookObject.toString();
    }
}