package rx_observer;


public interface Func1<T, R> extends Function {
    R call(T t);
}
