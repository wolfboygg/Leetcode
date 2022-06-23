package rx_observer;

public class Observable<T> {

    public static Observable create(OnSubscriber onSubscriber) {
        return new Observable(onSubscriber);
    }

    public interface OnSubscriber<T extends Subscriber> extends Action<T> {

    }

    public final <R> Observable<R> map(Func1<? super T, ? extends R> func) {
        return lift(new MapOperator<T, R>(func));
    }

    private final <R> Observable<R> lift(Operator<? extends R, ? super T> operator) {
        return new Observable<R>(new OnSubscriber() {
            @Override
            public void call(Subscriber subscriber) {
                Subscriber<? super T> st = operator.call(subscriber);
                onSubscriber.call(st);
            }
        });
    }

    /**
     * @param <T> 入参
     * @param <R> 出参
     */
    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    private OnSubscriber onSubscriber;

    public Observable(OnSubscriber onSubscriber) {
        this.onSubscriber = onSubscriber;
    }

    public void subscribe(Subscriber subscriber) {
        onSubscriber.call(subscriber);
    }
}
