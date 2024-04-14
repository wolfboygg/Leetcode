package review;

import sun.rmi.transport.ObjectTable;

import java.util.LinkedList;

public class Test {

    public Object lock = new Object();

    public volatile LinkedList<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {
        Test test = new Test();
        new ProductThread(test.queue, test.lock).start();
        new ConsumeThread(test.queue, test.lock).start();
    }


    public static class ProductThread extends Thread {

        private LinkedList<Integer> queue = null;
        private Object lock = null;

        public int index = 0;

        public ProductThread(LinkedList<Integer> queue, Object lock) {
            this.queue = queue;
            this.lock = lock;
        }

        @Override
        public void run() {
            super.run();
            synchronized (lock) {// String.class
                while (true) {
                    try {
                        if (queue.size() > 100) {
                            lock.wait();
                        } else if (queue.size() > 0) {
                            lock.notifyAll();
//                            System.out.println("product 11111111");
                        }
                        queue.offer(index);
                        System.out.println("product data:" + index);
                        index++;
                        lock.wait(10);
                    } catch (InterruptedException exception) {
                        // ignore
                    }
                }
            }
        }
    }

    public static class ConsumeThread extends Thread {

        private LinkedList<Integer> queue = null;
        private Object lock = null;

        public ConsumeThread(LinkedList<Integer> queue, Object lock) {
            this.queue = queue;
            this.lock = lock;
        }

        @Override
        public void run() {
            super.run();
            synchronized (lock) {
                while (true) {
//                    System.out.println("consume 0-0000");
                    try {
                        if (queue.size() == 0) {
                            lock.wait();
//                            System.out.println("consume 11111111");
                        } else {
                            Integer value = queue.poll();
                            System.out.println("consume data:" + value);
                        }
                        Thread.sleep(10);
                    } catch (Exception exception) {
                        // ignore
                    }
                }
            }
        }
    }


}
