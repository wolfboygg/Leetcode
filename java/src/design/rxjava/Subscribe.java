package design.rxjava;
public abstract class Subscribe<T> {
    public abstract void onNext(T t);

    public abstract void onComplete();

}
