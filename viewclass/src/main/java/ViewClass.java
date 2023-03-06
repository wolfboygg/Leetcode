import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ViewClass {
    public static void main(String[] args) throws InterruptedException {

        // 先睡一会
        Thread.sleep(5000);

        System.out.println("=============之前=================");

        ViewClass viewClass = new ViewClass();
        System.out.println("hahah");
        System.out.println(ClassLayout.parseInstance(viewClass).toPrintable());

        System.out.println("=============加锁=================");

        synchronized (viewClass) {
            System.out.println(ClassLayout.parseInstance(viewClass).toPrintable());
        }

        System.out.println("=============之后=================");

        System.out.println(ClassLayout.parseInstance(viewClass).toPrintable());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
    }
}
