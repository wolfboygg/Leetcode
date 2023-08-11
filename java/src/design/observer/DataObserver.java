package design.observer;
public class DataObserver implements Observer{
    @Override
    public void update() {
        System.out.println("数据更新了");
    }
}
