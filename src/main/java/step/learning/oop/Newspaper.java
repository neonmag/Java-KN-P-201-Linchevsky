package step.learning.oop;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
@Serializable
public class Newspaper extends Literature implements Periodic, Printable {
    private Date date;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat cardDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Newspaper(String title, String date) throws ParseException
    {
        this(title, dateFormat.parse(date));
    }

    public Newspaper(String title, Date date){
        super.setTitle(title);
        this.setDate(date);
    }


    public Date getDate() {
        return date;
    }
    @ParseChecker
    public static boolean isParseableFromJson(JsonObject jsonObject){
        String[] requiredFields = {"title", "date"};
        for (String field : requiredFields){
            if(!jsonObject.has(field)){
                return false;
            }
        }
        return true;
    }

    @FromJsonParser
    public static Newspaper fromJson(JsonObject jsonObject) throws ParseException{
        String[] requiredFields = {"title", "date"};
        for (String field : requiredFields){
            if(!jsonObject.has(field)){
                throw new ParseException("Missing required field: " + field, 0);
            }
        }

        return new Newspaper(
                jsonObject.get(requiredFields[0]).getAsString(),
                jsonObject.get(requiredFields[1]).getAsString()
        );
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String GetCard(){
        return String.format("Newspaper '%s' from %s", super.getTitle(), cardDateFormat.format(this.getDate()));
    }

    @Override
    public String GetPeriod() {
        return "daily";
    }
}