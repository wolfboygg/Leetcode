package rx_observer;

public interface Action<T extends Subscriber> {
    void call(T t);
}
