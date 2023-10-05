package step.learning.async;

public class AsyncDemo {
    public void run()
    {
        System.out.println( "Async demo" ) ;
        //multiThreadDemo();
        //Hw();
        sum = 100.0;
        for (int i = 0; i < 12; i++){
            new Thread(new MonthRate(i + 1)).start();
        }
    }
    private double sum;
    class MonthRate implements Runnable{
        public MonthRate(int month) {
            this.month = month;
        }

        private int month;
        @Override
        public void run() {
            try {
                Thread.sleep(1000); // иммитация запроса
            } catch (InterruptedException ignored) {}
            double p = 0.1; // иммитация результата запроса
            // "добавляем свой результат к общей сумме
            sum = sum * (1 + p);
            System.out.printf("month: %02d, percent: %.2f, sum: %.2f%n", month, p, sum);
        }
    }

    private void multiThreadDemo()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread starts");
                    Thread.sleep(2000);
                    System.out.println("Thread finishes");
                } catch (InterruptedException ex)
                {
                    System.err.println("Sleepin problem " + ex.getMessage());
                }
            }
        });
        thread.start();


        try {
            thread.join();
        }
        catch (InterruptedException ex)
        {
            System.err.println("Interrupted " + ex.getMessage());
        }

        new Thread( () -> {System.out.println("Thread 2 starts");} ).start();

        new Thread(this::methodForThread).start();

        System.out.println("multiThreadDemo() finishes");
    }

    private void methodForThread()
    {
        System.out.println("Thread 3");
    }
}
