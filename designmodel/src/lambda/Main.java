package lambda;

public class Main {
    public static void main(String[] args) {
//        Runnable runnable = () -> System.out.println("xxx");
//        new Thread(runnable).start();
        Runnable runnable = null;
        Thread thread = (Thread) runnable;
        System.out.println(thread);
    }
}
