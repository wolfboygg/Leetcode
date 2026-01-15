package leetcodereview01.new_top_100.producer_consume;

import java.util.LinkedList;

public class Test {

    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity = 100;
    private Object lock = new Object();

    class ProducerThread extends Thread {

        private LinkedList<Integer> list;

        public ProducerThread(LinkedList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            super.run();
            int index = 0;
            synchronized (lock) {
                try {
                    while(true) {
                        if (list.size() >= capacity) {
                            lock.wait();
                        } else {
                            if (list.size() > 0) {
                                lock.notifyAll();
                            }
                            System.out.println("producer index:" + (index + 1));
                            list.add(index++);
                            lock.wait(10);
                        }
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }

    class ConsumeThread extends Thread {

        private LinkedList<Integer> list;

        public ConsumeThread(LinkedList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            super.run();
            synchronized (lock) {
                try {
                    while(true) {
                        if (!list.isEmpty()) {
                            Integer poll = list.poll();
                            System.out.println("consume product is:" + poll);
                            if (list.size() < 100) {
                                lock.notifyAll();
                            }

                        } else {
                            lock.wait();
                        }
                    }
                } catch (InterruptedException e) {}
            }
        }
    }

    public void test() {
        new ProducerThread(list).start();
        new ConsumeThread(list).start();
    }

    public static void main(String[] args) {
        new Test().test();
    }


}
