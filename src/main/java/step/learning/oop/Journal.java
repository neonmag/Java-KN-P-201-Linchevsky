package step.learning.oop;

import com.google.gson.JsonObject;

import java.text.ParseException;

@Serializable
public class Journal extends Literature implements Copyable, Periodic, Printable, Multiple {
    public Journal(String title, int number, int count) {
        this.count = count;
        this.setNumber(number);
        super.setTitle(title);
    }
    @Override
    public String GetPeriod() {
        return "daily";
    }
    public Journal(String title, int number) {
        this.count = 1;
        this.setNumber(number);
        super.setTitle(title);
    }

    @ParseChecker
    public static boolean isParseableFromJson(JsonObject jsonObject) {
        String[] requiredFields = {"title", "number"};
        for (String field : requiredFields) {
            if (!jsonObject.has(field)) {
                return false;
            }
        }
        return true;
    }

    @FromJsonParser
    public static Journal fromJson(JsonObject jsonObject) throws ParseException {
        String[] requiredFields = {"title", "number"};
        for (String field : requiredFields) {
            if (!jsonObject.has(field)) {
                throw new ParseException("Missing required field: " + field, 0);
            }
        }

        return new Journal(
                jsonObject.get(requiredFields[0]).getAsString(),
                jsonObject.get(requiredFields[1]).getAsInt()
        );
    }

    public int GetNumber() {
        return Number;
    }

    public void setNumber(int number) {
        this.Number = number;
    }
    public String GetCard() {
        return String.format(
                "Journal '%s' №%s",
                super.getTitle(),
                this.GetNumber()
        );
    }
    @Override
    public int getCount() {
        return count;
    }
    private int Number;
    private int number;
    private int count;
}