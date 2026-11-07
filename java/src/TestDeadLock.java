public class TestDeadLock {

    static private Object lockA = new Object();
    static  private Object lockB = new Object();


    static class Thread1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("Thread1");
            synchronized (lockA) {
                try {
                    Thread.sleep(10 * 1000);
                    System.out.println("Thread1---1");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockB) {
                    System.out.println("hahahah---->A");
                }
            }
        }
    }

    static  class Thread2 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("Thread2");
            synchronized (lockB) {
                try {
                    Thread.sleep(10 * 1000);
                    System.out.println("Thread2---1");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockA) {
                    System.out.println("hahahah---->B");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }



}
