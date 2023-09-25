package step.learning.oop;

public class OopDemo {
    public void run()
    {
        Library library = new Library();
        try{
            library.add(new Book("D. Knuth", "Art of programming"));
            library.add(new Newspaper("Daily mail", "2023-09-25"));
            library.add(new Newspaper("Test1", "2023-09-25"));
            library.add(new Newspaper("Test12", "2023-09-25"));
            library.add(new Newspaper("Test13", "2023-09-25"));
            library.add(new Journal("Quantum mechanics", 157));
            library.add(new Journal("Quantum mechanics2", 157));
            library.add(new Journal("Quantum mechanics3", 157));

        }
        catch (Exception ex)
        {
            System.err.println("Literature creation error: " + ex.getMessage());
        }
        library.printAllCards();
        System.out.println("--------------COPYABLE--------------");
        library.printCopyable();
        System.out.println("--------------NONCOPYABLE--------------");
        library.printNonCopyable();
        System.out.println("--------------PERIODIC--------------");
        library.printPeriodic2();
        System.out.println("--------------NONPERIODIC--------------");
        library.printNonPeriodic();
    }

}


/*
Бібліотека
Моделюємо многосховище (бібліотеку) у якому є каталог (перелік наявних видань)
Видання є різного типу: книги, газети, журнали, тощо
Кожен тип має однакову картку у каталозі

Абстрагування
Література - термін, що поєднує реальні сутності (книги)
* */

/*
ООП - об'єктно-орієнтована парадигма програмування
Програма - управління об'єктами та їх взаємодією
Програмування - налаштування об'єктів та зв'язків
Види зв'язків:
 - спадкування
 - асоціація
 - композиція
 - агрегація
 - залежність
* */