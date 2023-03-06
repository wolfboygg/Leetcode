package rx_observer;

public interface Observer<T> {
    void onComplete();

    void onError();

    void onNext(T t);
}
