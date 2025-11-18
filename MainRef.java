public class MainRef {
    public static void main(String[] args) throws InterruptedException {
        SharedObjectExample sharedObj = new SharedObjectExample(0);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                int newValue = sharedObj.getValue() + 1;
                sharedObj.updateValue(newValue);
                System.out.println(Thread.currentThread().getName() + " -> " + sharedObj.getValue());
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final: " + sharedObj.getValue());
    }
}
