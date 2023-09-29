package step.learning.oop;

import com.google.gson.JsonObject;

import java.text.ParseException;

@Serializable
public class Book extends  Literature implements Copyable{
    public Book(String author, String title) {
        this.author = author;
        this.count = 1;
        super.setTitle(title);
    }

    private int count;
    private String author;
    @Override
    public String GetCard() {
        return String.format("Book^ %s '%s' ", getAuthor(), getTitle());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @FromJsonParser
    public static Book fromJson(JsonObject jsonObject) throws ParseException{
        String[] requiredFields = {"author", "title"};
        for (String field : requiredFields){
            if(!jsonObject.has(field)){
                throw new ParseException("Missing required field: " + field, 0);
            }
        }

        return new Book(
                jsonObject.get(requiredFields[0]).getAsString(),
                jsonObject.get(requiredFields[1]).getAsString()
        );
    }

    @ParseChecker
    public static boolean isParseableFromJson(JsonObject jsonObject){
        String[] requiredFields = {"author", "title"};
        for (String field : requiredFields){
            if(!jsonObject.has(field)){
                return false;
            }
        }
        return true;
    }

}