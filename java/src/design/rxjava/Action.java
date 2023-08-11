package design.rxjava;
public interface Action<T> {
    void call(Subscribe<T> subscribe);
}
