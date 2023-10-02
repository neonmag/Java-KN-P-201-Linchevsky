package step.learning;

import com.google.inject.Guice;
import com.google.inject.Injector;
import step.learning.basics.BasicsDemo;
import step.learning.basics.FilesDemo;
import step.learning.ioc.ConfigModule;
import step.learning.ioc.IocDemo;
import step.learning.oop.HWMaxString;
import step.learning.oop.OopDemo;

import javax.inject.Inject;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new ConfigModule());
        IocDemo iocDemo = injector.getInstance(IocDemo.class);
        iocDemo.run();
    }
}
/*
Вступ.
Встановити:
1. JRE (Java Runtime Environment - аналог .NET - платформа запуску)
    https://www.oracle.com/java/technologies/downloads/
2. JDK (Java Developer Kit - набір розробника - компілятор + бібліотеки)
    за тим самим посиланням або через інструменти IDE
3. IDE (JetBrains Idea / NetBeans (Apache) / Eclipse / VS Code)

Новий проєкт.
1. Архетип (система збірки / управління пакетами ~ NuGet)
    Maven / Gradle / Ant /Idea
    Назва проєкту - довільна
    Архетип - quickstart
    ! розкрити додаткові налаштування, вписати групу "step.learning"
    Вибрати JDK, за відсутності - завантажити
2. Конфігурація запуску - після створення проєкту маємо лише розпакованний
    шаблон, потрібна конфігурація.
        меню Run - Edit Configuration - Add new - Application
        Вводимо назву конфігурації (довільна, App)
        Та вибираємо головний клас (з методом main)
3. Пробний запуск
*/
/*
Про Java
Парадигма - ООП
Покоління - 4
Запуск - трансльований, на базі платформи
Вихідний код - Юнікод, файли.java
Виконавчий код - проміжний, файли.class
Висока чутливість до організації:
 - назва файлу зберігається з назвою класу (реєстрочутливо) ->
    один файл - один клас (public)
 - назва пакету відповідає назві директорії
*/