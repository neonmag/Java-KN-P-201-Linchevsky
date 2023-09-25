package step.learning.oop;
public class Journal extends Literature implements Copyable {
    private int number;
    private String title;
    public Journal(String title, int number) {
        this.setNumber(number);
        super.setTitle(title);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String GetCard() {
        return String.format(
                "Journal '%s' №%s",
                super.getTitle(),
                this.getNumber()
        );
    }
}