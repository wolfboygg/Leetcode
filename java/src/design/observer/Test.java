package design.observer;
public class Test {

    public static void main(String[] args){
        Observable observable = new Observable();
        DataObserver observer = new DataObserver();
        observable.addObserver(observer);
        observable.updateInfo();
    }
}
