package rx_observer;

public class MapOperator<T, R> implements Observable.Operator<R, T> {

    private final Func1<? super T, ? extends R> transformer;

    public MapOperator(Func1<? super T, ? extends R> transformer) {
        this.transformer = transformer;
    }

    @Override
    public Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        return new Subscriber<T>(subscriber) {
            @Override
            public void onComplete() {
                subscriber.onComplete();
            }

            @Override
            public void onError() {
                subscriber.onError();
            }

            @Override
            public void onNext(T t) {
                subscriber.onNext(transformer.call(t));
            }
        };
    }
}
