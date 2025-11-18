public class MainStatic {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (StaticShared.sharedObj) {
                    int newValue = StaticShared.sharedObj.getValue() + 1;
                    StaticShared.sharedObj.updateValue(newValue);
                    System.out.println(Thread.currentThread().getName() + " -> " + StaticShared.sharedObj.getValue());
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final: " + StaticShared.sharedObj.getValue());
    }
}
