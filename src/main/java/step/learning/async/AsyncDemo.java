package step.learning.async;

import java.util.concurrent.CountDownLatch;

public class AsyncDemo {
    public void run() {
        System.out.println( "Async demo" ) ;
        //multiThreadDemo();
        for (int i = 0; i <= 9; i++) {
            final int num = i;
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    result.append(num);
                    amount++;
                    if (amount == 10) {
                        System.out.println(result.toString());
                    }
                }
            });
            thread.start();
        }
        System.out.println("final");
    }
    private void multiThreadDemo(){
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Thread starts");
                            Thread.sleep(2000);
                            System.out.println("Thread finishes");
                        }
                        catch (InterruptedException ex){
                            System.err.println("Sleeping broken" + ex.getMessage());
                        }
                    }
                }
        );
        try {
            thread.join();
        }
        catch (InterruptedException ex){
            System.err.println("Thread joining interrupted" + ex.getMessage());
        }
        //      thread.start();
        System.out.println("multiThreadDemo() finishes");
    }
    private static final Object lock = new Object();
    private static final StringBuilder result = new StringBuilder();
    private static int amount = 0;
}
