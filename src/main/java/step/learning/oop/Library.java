package step.learning.oop;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Library {
    private final List<Literature> funds;

    public Library() {
        funds = new LinkedList<>();
    }

    public void add(Literature literature){
        funds.add(literature);
    }

    public void printAllCards(){
        for (Literature literature : funds){
            System.out.println(literature.GetCard());
        }
    }

    public void printCopyable(){
        for(Literature literature: funds)
        {
            if(isCopyable(literature))
            {
                System.out.println(literature.GetCard());
            }
        }
    }
    public void printNonCopyable(){
        for(Literature literature: funds)
        {
            if(!isCopyable(literature))
            {
                System.out.println(literature.GetCard());
            }
        }
    }

    public boolean isCopyable(Literature literature)
    {
        return literature instanceof Copyable;
    }

    public void printPeriodic()
    {
        for(Literature literature: funds)
        {
            if(isPeriodic(literature))
            {
                Periodic listAsPeriodic = (Periodic) literature;
                System.out.println(listAsPeriodic.GetPeriod() + " " + literature.GetCard());
            }
        }
    }
    public void printPeriodic2()
    {
        for(Literature literature: funds)
        {
            try{
                Method getPeriodMethod = literature.getClass().getDeclaredMethod("GetPeriod");
                System.out.println(getPeriodMethod.invoke(literature) + " " + literature.GetCard());
            }
            catch (Exception ignored)
            {

            }
        }
    }
    public void printNonPeriodic()
    {
        for(Literature literature: funds)
        {
            if(!isPeriodic(literature))
            {
                System.out.println(literature.GetCard());
            }
        }
    }
    public boolean isPeriodic(Literature literature)
    {
        return literature instanceof Periodic;
    }
}
